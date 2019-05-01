package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoying.apartment.dao.BedMapper;
import com.luoying.apartment.dao.DormitoryMapper;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.service.IBedService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Bed> list(Long dormitoryId) {
        Bed bed=new Bed();
        bed.setDormitoryId(dormitoryId);
        return this.baseMapper.queryBedList(bed);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addBed(Bed bed) {
        Dormitory dormitory = dormitoryMapper.selectById(bed.getDormitoryId());
        Integer quantity=dormitory.getBedQuantity();
        if(quantity==null)quantity=0;
        quantity++;
        dormitory.setBedQuantity(quantity);
        dormitory.setStatus(0);
        dormitoryMapper.updateById(dormitory);
        this.save(bed);
    }
}
