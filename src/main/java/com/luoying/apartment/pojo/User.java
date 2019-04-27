package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_user")
public class User {

    private Long Id;

    private String username;

    private String password;

    private Integer userType;

    private Long studentId;

    private Date createDate;

    private Date updateDate;

}
