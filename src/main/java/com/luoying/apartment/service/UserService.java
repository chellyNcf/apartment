package com.luoying.apartment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;

public interface UserService extends IService<User> {

    void addUser(User user);

    void updatePwd(String password,String newPassword,String confirmPassword);

    User getUserById(Long id);

    MyPage<User> getUserPage(MyPage<User> page);
}
