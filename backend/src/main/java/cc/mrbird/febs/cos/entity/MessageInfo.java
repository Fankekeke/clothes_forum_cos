package cc.mrbird.febs.cos.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 系统消息
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MessageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 发送用户
     */
    private Long sendUser;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 状态 0.未读 1.已读
     */
    private Integer readStatus;

    @TableField(exist = false)
    private String username;

    public MessageInfo(Long sendUser, String content, String createDate, Integer readStatus) {
        this.sendUser = sendUser;
        this.content = content;
        this.createDate = createDate;
        this.readStatus = readStatus;
    }

    public MessageInfo() {}
}
