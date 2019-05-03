package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.constant.UserTypeEnum;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.UserService;
import com.luoying.apartment.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


    @Override
    public void addUser(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        MyUtil.check(!StringUtils.isEmpty(username));
        MyUtil.check(!StringUtils.isEmpty(password));

        User queryUser = new User();
        queryUser.setUsername(username);
        int count = this.baseMapper.selectCount(new QueryWrapper<>(queryUser));
        MyUtil.check(count == 0, "用户名已存在");
        user.setUserType(UserTypeEnum.ADMIN.getValue());
        user.setUserStatus(0);
        user.setPassword(MyUtil.pwdMd5(password));
        save(user);
    }

    @Override
    public User getUserById(Long id) {
        return this.baseMapper.getUserById(id);
    }

    @Override
    public MyPage<User> getUserPage(MyPage<User> page) {
        page.setCount(this.baseMapper.getUserPageCount(page.getParams()));
        page.setRecords(this.baseMapper.getUserPage(page.getParams()));
        return page;
    }

}

