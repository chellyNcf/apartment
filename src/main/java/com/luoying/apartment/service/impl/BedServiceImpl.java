package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoying.apartment.dao.BedMapper;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.service.IBedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 床位表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-24
 */
@Service
public class BedServiceImpl extends ServiceImpl<BedMapper, Bed> implements IBedService {

    @Override
    public List<Bed> list(Long dormitoryId) {
        Bed bed=new Bed();
        bed.setDormitoryId(dormitoryId);
        Wrapper<Bed> bedWrapper=new QueryWrapper<>(bed);
        return this.list(bedWrapper);
    }
}
