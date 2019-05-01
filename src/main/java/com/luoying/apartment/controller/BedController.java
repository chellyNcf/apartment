package com.luoying.apartment.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.service.IBedService;
import com.luoying.apartment.service.impl.BedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private IBedService bedService;

    @GetMapping("/list")
    public ResultMsg getBedList(@RequestParam Long dormitoryId){

        return ResultMsgFactory.createSuccessMsg(bedService.list(dormitoryId));
    }

    @PostMapping
    public ResultMsg add(@RequestBody Bed bed){

        bedService.addBed(bed);
        return ResultMsgFactory.createSuccessMsg();
    }


}

