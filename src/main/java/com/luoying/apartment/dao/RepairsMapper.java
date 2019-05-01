package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.Repairs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 报修表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface RepairsMapper extends BaseMapper<Repairs> {

    List<Repairs> queryRepairsPage(Map<String, Object> params);

    int queryRepairsPageCount(Map<String, Object> params);

    Repairs queryRepairsById(Long id);
}
