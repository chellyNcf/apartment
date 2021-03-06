package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.SignIn;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 签到表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface ISignInService extends IService<SignIn> {

    MyPage<SignIn> getSignInPage(MyPage<SignIn> page);

    void signIn(MultipartFile multipartFile);
}
