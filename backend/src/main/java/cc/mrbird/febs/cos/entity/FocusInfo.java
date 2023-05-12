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
 * 关注用户
 *
 * @author FanK
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FocusInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Long userId;

    /**
     * 收藏用户
     */
    private Long collectUserId;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 删除标识
     */
    private Integer deleteFlag;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String collectUsername;
}
