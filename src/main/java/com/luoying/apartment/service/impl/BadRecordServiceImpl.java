package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.BadRecord;
import com.luoying.apartment.dao.BadRecordMapper;
import com.luoying.apartment.service.IBadRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 违规表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class BadRecordServiceImpl extends ServiceImpl<BadRecordMapper, BadRecord> implements IBadRecordService {

    @Override
    public MyPage<BadRecord> getBadRecordPage(MyPage<BadRecord> page) {
        page.setRecords(this.baseMapper.queryBadRecordPage(page.getParams()));
        page.setCount(this.baseMapper.queryBadRecordCount(page.getParams()));
        return page;
    }

    @Override
    public BadRecord getBadRecordById(Long id) {
        return this.baseMapper.queryBadRecordById(id);
    }
}
