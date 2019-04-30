package com.luoying.apartment.service.impl;

import com.luoying.apartment.pojo.Apartment;
import com.luoying.apartment.dao.ApartmentMapper;
import com.luoying.apartment.service.IApartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 公寓表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-29
 */
@Service
public class ApartmentServiceImpl extends ServiceImpl<ApartmentMapper, Apartment> implements IApartmentService {

}
