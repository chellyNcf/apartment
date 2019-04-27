package com.luoying.apartment.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.service.IBedService;
import com.luoying.apartment.service.impl.BedServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.luoying.apartment.base.controller.BaseController;

/**
 * <p>
 * 床位表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/apartment/bed")
public class BedController extends BaseController{

    private IBedService bedService;

    @GetMapping("/list")
    public ResultMsg getBedList(){

        return ResultMsgFactory.createSuccessMsg(bedService.list());
    }


}

