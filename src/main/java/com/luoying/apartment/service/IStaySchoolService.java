package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.StaySchool;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 寒暑假留校表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface IStaySchoolService extends IService<StaySchool> {

    MyPage<StaySchool> getStaySchoolPage(MyPage<StaySchool> page);

}
