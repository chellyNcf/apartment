package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Repairs;
import com.luoying.apartment.dao.RepairsMapper;
import com.luoying.apartment.service.IRepairsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 报修表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class RepairsServiceImpl extends ServiceImpl<RepairsMapper, Repairs> implements IRepairsService {

    @Override
    public MyPage<Repairs> getRepairsPage(MyPage<Repairs> page) {
        page.setRecords(this.baseMapper.queryRepairsPage(page.getParams()));
        page.setCount(this.baseMapper.queryRepairsPageCount(page.getParams()));
        return page;
    }

    @Override
    public Repairs getRepairsById(Long id) {
        Repairs repairs = this.baseMapper.queryRepairsById(id);
        return repairs;
    }
}
