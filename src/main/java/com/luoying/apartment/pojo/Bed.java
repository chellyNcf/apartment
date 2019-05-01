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
 * 床位表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_bed")
public class Bed extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 床位号
     */
    private String bedNum;

    /**
     * 学生id
     */
    private Long studenId;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 床位状态 0未占用，1已占用
     */
    private Integer status;

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

}
