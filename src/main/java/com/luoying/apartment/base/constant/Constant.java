package com.luoying.apartment.base.constant;

import org.springframework.util.Base64Utils;

public class Constant {

    /**
     * MD5盐
     */
    public static final String SALT="apartment";

    public static final String AUDIENCE="web";

    public static final String ISSUER="server_api";

    /**
     * 一天（毫秒）
     */
    public static final long TTLMILLIS=24*60*60*1000;

    /**
     * base64秘钥
     */
    public static final String BASE64_SECURITY=Base64Utils.encodeToString("LuoYing".getBytes());

}
