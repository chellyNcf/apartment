package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_student")
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    private String studentNum;

    /**
     * 学生名
     */
    private String studentName;

    /**
     * 院系
     */
    private String department;

    /**
     * 班级
     */
    private String clazz;

    /**
     * 性别：1男2女
     */
    private Integer sex;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd")//返回格式
    private Date birthdate;

    /**
     * 手机
     */
    private String phone;

    /**
     * 床位id
     */
    private Long bedId;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 0未入住，1已入住，2退宿
     */
    private Integer status;

    @TableField(exist = false)
    private Integer age;

    @TableField(exist = false)
    private String apartmentName;

    @TableField(exist = false)
    private String bedNum;

    @TableField(exist = false)
    private String building;

    @TableField(exist = false)
    private String dormitoryNum;
}
