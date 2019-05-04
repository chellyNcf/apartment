package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.SignIn;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 签到表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface SignInMapper extends BaseMapper<SignIn> {

    List<SignIn> querySignInPage(Map<String,Object> map);

    int querySignInCount(Map<String,Object> map);

}
