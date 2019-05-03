package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_user")
public class User extends BaseEntity {

    private String username;

    private String password;

    /**
     * 用户类型 0管理员 1普通用户（学生）
     */
    private Integer userType;

    /**
     * 关联的学生
     */
    private Long studentId;

    /**
     * 用户状态
     */
    private Integer userStatus;

    /**
     * 联系方式
     */
    private String phone;

    @TableField(exist = false)
    private String token;

}
