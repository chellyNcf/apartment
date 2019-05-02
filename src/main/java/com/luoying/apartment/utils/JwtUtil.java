package com.luoying.apartment.utils;


import com.luoying.apartment.pojo.User;
import io.jsonwebtoken.Jwts;

public class JwtUtil {

    private static final ThreadLocal<User> LOGIN_USER=new ThreadLocal<>();

    public static User getUser(){

        User user=LOGIN_USER.get();
        if(user==null){//登录未实现，临时处理
            user=new User();
            user.setId(-1l);//管理员
            user.setUsername("admin");
        }
        return user;
    }

    public static String createJson(){

//        Jwts.
        return "";
    }
}
