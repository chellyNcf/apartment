package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Repairs;
import com.baomidou.mybatisplus.extension.service.IService;
import com.luoying.apartment.pojo.User;

/**
 * <p>
 * 报修表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface IRepairsService extends IService<Repairs> {

    MyPage<Repairs> getRepairsPage(MyPage<Repairs> page);

    Repairs getRepairsById(Long id);

    void addRepairs(Repairs repairs, User user);

    void updateRepairs(Repairs repairs, User user);
}
