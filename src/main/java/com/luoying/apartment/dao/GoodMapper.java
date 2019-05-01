package com.luoying.apartment.dao;

import com.luoying.apartment.pojo.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 大件物品表 Mapper 接口
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface GoodMapper extends BaseMapper<Good> {


    int queryGoodPageCount(Map<String, Object> params);

    List<Good> queryGoodPage(Map<String, Object> params);

    Good queryGoodById(Long id);
}
