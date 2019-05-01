package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 寒暑假留校表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_stay_school")
public class StaySchool extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 留宿原因
     */
    private String reason;

    /**
     * 开始日期
     */
    private LocalDateTime beginTime;

    /**
     * 结束日期
     */
    private LocalDateTime endTime;

    /**
     * 0未审核，-1不通过，1通过
     */
    private Integer status;

    /**
     * 审核理由
     */
    private String auditReason;

    /**
     * 审核人
     */
    private String auditUserId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 审核人
     */
    @TableField(exist = false)
    private String auditUserName
            ;
    /**
     * 学号
     */
    @TableField(exist = false)
    private String studentNum;

    /**
     * 学生名
     */
    @TableField(exist = false)
    private String studentName;
}
