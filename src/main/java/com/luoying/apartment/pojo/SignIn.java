package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 签到表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_sign_in")
public class SignIn extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long studentId;

    private Long dormitoryId;

    /**
     * 0机器签到，1手动签到
     */
    private Integer signInType;

    /**
     * 1代表已经签到
     */
    private Integer success;

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

    @TableField(exist = false)
    private String apartmentName;

    @TableField(exist = false)
    private String dormitoryNum;

}
