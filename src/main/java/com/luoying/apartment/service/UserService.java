package com.luoying.apartment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoying.apartment.pojo.User;

public interface UserService extends IService<User> {

    void addUser(User user);
}
