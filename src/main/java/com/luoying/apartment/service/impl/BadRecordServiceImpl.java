package com.luoying.apartment.service.impl;

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

}
