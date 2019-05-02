package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
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

    @Override
    public MyPage<People> getPeoplePage(MyPage<People> page) {
        page.setRecords(this.baseMapper.queryPeoplePage( page.getParams()));
        page.setCount(this.baseMapper.queryPeopleCount(page.getParams()));
        return page;
    }

    @Override
    public People getPeopleById(Long id) {
        return this.baseMapper.queryPeopleById(id);
    }
}
