package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.Bed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 床位表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-25
 */
public interface BedMapper extends BaseMapper<Bed> {

    List<Bed> queryBedList(Bed bed);

}
