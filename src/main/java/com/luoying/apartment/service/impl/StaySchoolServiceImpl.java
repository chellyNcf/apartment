package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.StaySchool;
import com.luoying.apartment.dao.StaySchoolMapper;
import com.luoying.apartment.service.IStaySchoolService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 寒暑假留校表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class StaySchoolServiceImpl extends ServiceImpl<StaySchoolMapper, StaySchool> implements IStaySchoolService {


    @Override
    public MyPage<StaySchool> getStaySchoolPage(MyPage<StaySchool> page) {

        page.setRecords(this.baseMapper.queryStaySchoolPage( page.getParams()));
        page.setCount(this.baseMapper.queryStaySchoolCount(page.getParams()));
        return page;
    }
}
