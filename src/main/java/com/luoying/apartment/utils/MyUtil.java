package com.luoying.apartment.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;

public class MyUtil {

    public static int getInt(Object obj){
        if(null!=obj){
            try {
                return Integer.valueOf(obj.toString());
            }catch(Exception e) {

            }
        }
        return 0;
    }


    public static String ObjectToString(Object obj){
        return obj==null?"":obj.toString();
    }

}
