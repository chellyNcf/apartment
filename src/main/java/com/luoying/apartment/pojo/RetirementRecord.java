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
 * 退宿记录表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_retirement_record")
public class RetirementRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 退宿原因
     */
    private String reason;

    /**
     * 退宿日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd")//返回格式
    private Date retirementDate;

    /**
     * 床位id
     */
    private Long bedId;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 学生名
     */
    @TableField(exist = false)
    private String studentName;

    /**
     * 学号
     */
    @TableField(exist = false)
    private String studentNum;

    /**
     * 院系
     */
    @TableField(exist = false)
    private String department;

    /**
     * 班级
     */
    @TableField(exist = false)
    private String clazz;

    /**
     * 宿舍信息
     */
    @TableField(exist = false)
    private String dormitoryInfo;

    @TableField(exist = false)
    private String apartmentName;

    @TableField(exist = false)
    private String bedNum;

    @TableField(exist = false)
    private String dormitoryNum;
}
