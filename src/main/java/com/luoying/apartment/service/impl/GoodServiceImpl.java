package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Good;
import com.luoying.apartment.dao.GoodMapper;
import com.luoying.apartment.service.IGoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 大件物品表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

    @Override
    public MyPage<Good> getGoodPage(MyPage<Good> page) {
        page.setCount(this.baseMapper.queryGoodPageCount(page.getParams()));
        page.setRecords(this.baseMapper.queryGoodPage(page.getParams()));
        return page;
    }

    @Override
    public Good getGoodById(Long id) {
        return this.baseMapper.queryGoodById(id);
    }
}
