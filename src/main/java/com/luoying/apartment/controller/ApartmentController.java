package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Apartment;
import com.luoying.apartment.service.IApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

/**
 * <p>
 * 公寓表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-29
 */
@RestController
@RequestMapping("/apartment/apartment")
public class ApartmentController extends BaseController {

    @Autowired
    private IApartmentService apartmentService;

    @GetMapping("/list")
    public ResultMsg getAll(){

        return ResultMsgFactory.createSuccessMsg(apartmentService.list());
    }

    @PostMapping
    public ResultMsg add(@RequestBody Apartment apartment){

        apartmentService.save(apartment);
        return ResultMsgFactory.createSuccessMsg();
    }

    @PutMapping
    public ResultMsg update(@RequestBody Apartment apartment){

        apartmentService.updateById(apartment);
        return ResultMsgFactory.createSuccessMsg();
    }

}

