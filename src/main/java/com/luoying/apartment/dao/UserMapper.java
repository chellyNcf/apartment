package com.luoying.apartment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luoying.apartment.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User> {
    List<User> getUserPage(Map<String,Object> params);
    int getUserPageCount(Map<String,Object> params);
    User getUserById(Long id);
}
