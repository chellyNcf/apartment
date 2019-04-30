package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.Dormitory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 宿舍表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface DormitoryMapper extends BaseMapper<Dormitory> {

    List<Dormitory> queryDormitoryPage(Map<String ,Object> map);

    int queryDormitoryCount(Map<String ,Object> map);

}
