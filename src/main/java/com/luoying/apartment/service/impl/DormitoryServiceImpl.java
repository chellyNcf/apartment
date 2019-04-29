package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.dao.DormitoryMapper;
import com.luoying.apartment.service.IDormitoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public MyPage<Dormitory> getDormitoryPage(MyPage<Dormitory> page) {
        page.setRecords(this.baseMapper.queryDormitoryPage(page.getParams()));
        page.setCount(this.baseMapper.queryDormitoryCount(page.getParams()));
        return page;
    }

    @Override
    public boolean save(Dormitory entity) {
        entity.setBedQuantity(0);
        return super.save(entity);
    }
}
