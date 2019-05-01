package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.BadRecord;
import com.luoying.apartment.service.IBadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 违规表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/bad-record")
public class BadRecordController extends BaseController {
    @Autowired
    private IBadRecordService badRecordService;

    @GetMapping("/page")
    public ResultMsg getBadRecordPage(@RequestParam Map<String,Object> params){
        logger.info("分页获取违规记录");
        MyPage<BadRecord> page = new MyPage<>(params);
        page=badRecordService.getBadRecordPage(page);
        ResultMsg resultMsg = ResultMsgFactory.createSuccessMsg();
        resultMsg.setCount(page.getCount());
        resultMsg.setData(page.getRecords());
        return resultMsg;
    }

    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id")Long id){
        logger.info("查询违规记录{}",id);
        return ResultMsgFactory.createSuccessMsg(badRecordService.getBadRecordById(id));
    }
    @PostMapping
    public ResultMsg add(@RequestBody BadRecord badRecord){
        logger.info("保存违规记录{}",badRecord);
        badRecordService.save(badRecord);
       return ResultMsgFactory.createSuccessMsg();
    }
    @DeleteMapping("/{id}")
    public ResultMsg delete(@PathVariable("id")Long id){
        logger.info("删除违规记录{}",id);
        badRecordService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }
    @PutMapping
    public ResultMsg update(@RequestBody BadRecord badRecord){
        logger.info("更新违规记录{}",badRecord);
        badRecord.setUpdateDate(new Date());
        badRecordService.updateById(badRecord);
        return ResultMsgFactory.createSuccessMsg();
    }

}

