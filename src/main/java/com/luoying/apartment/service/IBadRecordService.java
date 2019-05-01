package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.BadRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 违规表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface IBadRecordService extends IService<BadRecord> {

    MyPage<BadRecord> getBadRecordPage(MyPage<BadRecord> page);

    BadRecord getBadRecordById(Long id);
}
