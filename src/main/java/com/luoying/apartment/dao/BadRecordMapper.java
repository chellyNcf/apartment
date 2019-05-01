package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.BadRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 违规表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface BadRecordMapper extends BaseMapper<BadRecord> {

    List<BadRecord> queryBadRecordPage(Map<String, Object> params);

    int queryBadRecordCount(Map<String, Object> params);

    BadRecord queryBadRecordById(Long id);
}
