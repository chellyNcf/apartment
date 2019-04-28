package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_user")
public class User extends BaseEntity {

    private String username;

    private String password;

    private Integer userType;

    private Long studentId;


}
