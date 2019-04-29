package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.People;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 外访人员表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface PeopleMapper extends BaseMapper<People> {

    List<People> queryPeoplePage(Map<String, Object> params);

    int queryPeopleCount(Map<String, Object> params);
}
