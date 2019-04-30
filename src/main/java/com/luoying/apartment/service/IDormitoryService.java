package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Dormitory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 宿舍表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface IDormitoryService extends IService<Dormitory> {

    MyPage<Dormitory>  getDormitoryPage(MyPage<Dormitory> page);
}
