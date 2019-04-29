package com.luoying.apartment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luoying.apartment.pojo.Bed;

import java.util.List;

/**
 * <p>
 * 床位表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-24
 */
public interface IBedService extends IService<Bed> {

    List<Bed> list(Long dormitoryId);

}
