package com.luoying.apartment.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.service.IDormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Map;

/**
 * <p>
 * 宿舍表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/dormitory")
public class DormitoryController extends BaseController {

    @Autowired
    private IDormitoryService dormitoryService;

    /**
     * 获取list
     * @return
     */
    @GetMapping("/list")
    public ResultMsg getDormitoryList(@RequestParam Dormitory dormitory){

        return ResultMsgFactory.createSuccessMsg( dormitoryService.list(new QueryWrapper<>(dormitory)));
    }

    /**
     * 分页
     * @return
     */
    @GetMapping("/page")
    public ResultMsg getDormitoryPage(@RequestParam Map<String,Object> params){

        MyPage<Dormitory> page=new MyPage<>(params);
        page=dormitoryService.getDormitoryPage(page);
        ResultMsg resultMsg=ResultMsgFactory.createSuccessMsg( page.getRecords());
        resultMsg.setCount(page.getCount());
        return resultMsg;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody Dormitory dormitory){

        dormitoryService.save(dormitory);
        return ResultMsgFactory.createSuccessMsg();
    }
}

