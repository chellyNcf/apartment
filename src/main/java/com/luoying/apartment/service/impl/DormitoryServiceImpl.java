package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.dao.ApartmentMapper;
import com.luoying.apartment.pojo.Apartment;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.dao.DormitoryMapper;
import com.luoying.apartment.service.IDormitoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 宿舍表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class DormitoryServiceImpl extends ServiceImpl<DormitoryMapper, Dormitory> implements IDormitoryService {

    @Autowired
    private ApartmentMapper apartmentMapper;

    @Override
    public MyPage<Dormitory> getDormitoryPage(MyPage<Dormitory> page) {
        page.setRecords(this.baseMapper.queryDormitoryPage(page.getParams()));
        page.setCount(this.baseMapper.queryDormitoryCount(page.getParams()));
        return page;
    }

    @Override
    public Dormitory getDormitory(Long id) {
        Dormitory dormitory=this.getById(id);
        Apartment apartment = apartmentMapper.selectById(dormitory.getApartmentId());
        dormitory.setApartmentName(apartment.getApartmentName());
        return dormitory;
    }

    @Override
    public boolean save(Dormitory entity) {
        entity.setBedQuantity(0);
        return super.save(entity);
    }
}
