package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd")//返回格式
    private Date beginTime;

    /**
     * 结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd")//返回格式
    private Date endTime;

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
    private Long auditUserId;

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
