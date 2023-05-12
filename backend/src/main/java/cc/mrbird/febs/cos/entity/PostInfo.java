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
 * 贴子消息
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PostInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 贴子标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String images;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 浏览量
     */
    private Integer pageviews;

    private String tagIds;

    /**
     * 删除标识
     */
    private Integer deleteFlag;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private Integer tagId;

}
