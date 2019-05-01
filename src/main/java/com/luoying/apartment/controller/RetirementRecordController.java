package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.RetirementRecord;
import com.luoying.apartment.service.IRetirementRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Map;

/**
 * <p>
 * 退宿记录表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/retirement-record")
public class RetirementRecordController extends BaseController {

    @Autowired
    private IRetirementRecordService retirementRecordService;

    @GetMapping("/page")
    public ResultMsg getpage(@RequestParam Map<String,Object> params){

        MyPage<RetirementRecord> recordMyPage=new MyPage<>(params);

        recordMyPage=retirementRecordService.getRetirementRecordPage(recordMyPage);
        ResultMsg resultMsg=ResultMsgFactory.createSuccessMsg(recordMyPage.getRecords());
        resultMsg.setCount(recordMyPage.getCount());
        return resultMsg;
    }

    @PostMapping
    public ResultMsg add(@RequestBody RetirementRecord retirementRecord){


        retirementRecordService.addRetirementRecord(retirementRecord);
        return ResultMsgFactory.createSuccessMsg();
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){

        retirementRecordService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }
}

