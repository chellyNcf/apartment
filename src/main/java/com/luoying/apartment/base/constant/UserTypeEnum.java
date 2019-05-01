package com.luoying.apartment.base.constant;

import lombok.Getter;

/**
 * 用户类型：0管理员1普通用户
 */
@Getter
public enum UserTypeEnum {

    /**
     * 管理员
     */
    ADMIN(0,"管理员"),

    /**
     * 普通用户
     */
    NORMAL_USER(1,"普通用户");

    UserTypeEnum(int value,String desc){
        this.value=value;
        this.desc=desc;
    }

    private int value;

    private String desc;
}
