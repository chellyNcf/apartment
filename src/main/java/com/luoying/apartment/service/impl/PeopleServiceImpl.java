package com.luoying.apartment.service.impl;

import com.luoying.apartment.pojo.People;
import com.luoying.apartment.dao.PeopleMapper;
import com.luoying.apartment.service.IPeopleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 外访人员表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements IPeopleService {

}