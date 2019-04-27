package com.luoying.apartment.service.impl;

import com.luoying.apartment.pojo.SignIn;
import com.luoying.apartment.dao.SignInMapper;
import com.luoying.apartment.service.ISignInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 签到表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class SignInServiceImpl extends ServiceImpl<SignInMapper, SignIn> implements ISignInService {

}
