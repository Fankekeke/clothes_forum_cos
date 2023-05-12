<template>
  <a-card :bordered="false" class="card-area">
    <a-row>
      <a-col span="8">
        <a-card :bordered="false">
          <a-form :form="form" layout="vertical">
            <a-row :gutter="20">
              <a-col :span="24">
                <a-form-item label='名称' v-bind="formItemLayout">
                  <a-input v-decorator="[
                  'name',
                  { rules: [{ required: true, message: '请输入名称!' }] }
                  ]"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label='性别' v-bind="formItemLayout">
                  <a-select v-decorator="[
                    'sex'
                    ]">
                    <a-select-option value="1">男</a-select-option>
                    <a-select-option value="2">女</a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label='个人介绍' v-bind="formItemLayout">
                  <a-input v-decorator="[
                  'content'
                  ]"/>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item label='图册'>
                  <a-upload
                    name="avatar"
                    action="http://127.0.0.1:9527/file/fileUpload/"
                    list-type="picture-card"
                    :file-list="fileList"
                    @preview="handlePreview"
                    @change="picHandleChange"
                  >
                    <div v-if="fileList.length < 1">
                      <a-icon type="plus" />
                      <div class="ant-upload-text">
                        Upload
                      </div>
                    </div>
                  </a-upload>
                  <a-modal :visible="previewVisible" :footer="null" @cancel="handleCancel">
                    <img alt="example" style="width: 100%" :src="previewImage" />
                  </a-modal>
                </a-form-item>
              </a-col>
              <a-col :span="24">
                <a-form-item>
                  <a-button
                    size="large"
                    type="primary"
                    htmlType="submit"
                    class="register-button"
                    style="width: 35%;float: right;margin-top: 50px"
                    :loading="loading"
                    @click.stop.prevent="handleSubmit"
                    :disabled="loading">立即修改
                  </a-button>
                </a-form-item>
              </a-col>
            </a-row>
          </a-form>
        </a-card>
      </a-col>
    </a-row>
  </a-card>
</template>

<script>
import {mapState} from 'vuex'
import moment from 'moment'
moment.locale('zh-cn')
const formItemLayout = {
  labelCol: { span: 24 },
  wrapperCol: { span: 24 }
}
function getBase64 (file) {
  return new Promise((resolve, reject) => {
    const reader = new FileReader()
    reader.readAsDataURL(file)
    reader.onload = () => resolve(reader.result)
    reader.onerror = error => reject(error)
  })
}
export default {
  name: 'User',
  data () {
    return {
      rowId: null,
      formItemLayout,
      form: this.$form.createForm(this),
      loading: false,
      fileList: [],
      previewVisible: false,
      previewImage: ''
    }
  },
  computed: {
    ...mapState({
      currentUser: state => state.account.user
    })
  },
  mounted () {
    this.dataInit()
  },
  methods: {
    dataInit () {
      this.dataLoading = true
      this.$get(`/cos/user-info/detail/${this.currentUser.userId}`).then((r) => {
        console.log(r.data)
        this.rowId = r.data.data.id
        this.imagesInit(r.data.data.images)
        this.setFormValues(r.data.data)
        this.dataLoading = false
      })
    },
    setFormValues ({...teacherInfo}) {
      this.rowId = teacherInfo.id
      let fields = ['name', 'content', 'sex']
      let obj = {}
      Object.keys(teacherInfo).forEach((key) => {
        if (fields.indexOf(key) !== -1) {
          this.form.getFieldDecorator(key)
          obj[key] = teacherInfo[key]
        }
        if (key === 'sex' && teacherInfo[key] !== null) {
          obj[key] = teacherInfo[key].toString()
        }
      })
      this.form.setFieldsValue(obj)
    },
    handleSubmit () {
      // eslint-disable-next-line handle-callback-err
      // 获取图片List
      let images = []
      this.fileList.forEach(image => {
        if (image.response !== undefined) {
          images.push(image.response)
        } else {
          images.push(image.name)
        }
      })
      images = images.length > 0 ? images.join(',') : null
      // eslint-disable-next-line handle-callback-err
      this.form.validateFields((err, values) => {
        values.id = this.rowId
        values.images = images
        this.loading = true
        this.$put('/cos/user-info', {
          ...values
        }).then((r) => {
          this.$message.success('修改信息成功')
          this.loading = false
          this.dataInit()
        }).catch(() => {
          this.loading = false
        })
      })
    },
    submit () {
      // 获取图片List
      let images = []
      this.fileList.forEach(image => {
        if (image.response !== undefined) {
          images.push(image.response)
        } else {
          images.push(image.name)
        }
      })
      images = images.length > 0 ? images.join(',') : null
      this.$put(`/cos/home-info`, {
        images
      }).then((r) => {
        this.selectHomeDetail()
        this.$message.success('修改成功')
      })
    },
    handleCancel () {
      this.previewVisible = false
    },
    async handlePreview (file) {
      if (!file.url && !file.preview) {
        file.preview = await getBase64(file.originFileObj)
      }
      this.previewImage = file.url || file.preview
      this.previewVisible = true
    },
    picHandleChange ({ fileList }) {
      this.fileList = fileList
    },
    imagesInit (images) {
      if (images !== null && images !== '') {
        let imageList = []
        images.split(',').forEach((image, index) => {
          imageList.push({uid: index, name: image, status: 'done', url: 'http://127.0.0.1:9527/imagesWeb/' + image})
        })
        this.fileList = imageList
      }
    }
  },
  watch: {}
}
</script>
<style lang="less" scoped>
@import "../../../../static/less/Common";
</style>
