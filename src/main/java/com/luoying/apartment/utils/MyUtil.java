package com.luoying.apartment.utils;

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
