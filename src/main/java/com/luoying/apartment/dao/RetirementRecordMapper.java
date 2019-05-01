package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.RetirementRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 退宿记录表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface RetirementRecordMapper extends BaseMapper<RetirementRecord> {

    List<RetirementRecord> queryRetirementRecordPage(Map<String,Object> map);

    Integer queryRetirementRecordCount(Map<String,Object> map);

}
