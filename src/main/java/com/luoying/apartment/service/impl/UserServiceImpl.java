package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}
