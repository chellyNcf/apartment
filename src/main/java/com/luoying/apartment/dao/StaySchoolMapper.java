package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.StaySchool;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 寒暑假留校表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface StaySchoolMapper extends BaseMapper<StaySchool> {


    List<StaySchool> queryStaySchoolPage(Map<String,Object> map);

    int queryStaySchoolCount(Map<String,Object> map);

}
