package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Good;
import com.luoying.apartment.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.luoying.apartment.base.controller.BaseController;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 大件物品表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/good")
public class GoodController extends BaseController {
    @Autowired
    private IGoodService goodService;


    @GetMapping("/page")
    public ResultMsg getGoodPage(@RequestParam Map<String,Object> params){
        logger.info("获取大宗物分页");
        MyPage<Good> page = new MyPage<>(params);
        ResultMsg resultMsg  = ResultMsgFactory.createSuccessMsg();
        page=goodService.getGoodPage(page);
        resultMsg.setCount(page.getCount());
        resultMsg.setData(page.getRecords());
        return resultMsg;
    }


    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id){
        logger.info("查询大宗物品信息{}",id);
        return ResultMsgFactory.createSuccessMsg(goodService.getGoodById(id));
    }

    @PostMapping
    public ResultMsg add(@RequestBody Good good){
        logger.info("保存大宗物品信息{}",good);
        goodService.save(good);
        return ResultMsgFactory.createSuccessMsg();
    }

    @DeleteMapping("/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        logger.info("删除大宗物品信息{}",id);
        goodService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }

    @PutMapping
    public ResultMsg update(@RequestBody Good good){
        logger.info("更新大宗物品信息{}",good);
        good.setUpdateDate(new Date());
        goodService.updateById(good);
        return ResultMsgFactory.createSuccessMsg();
    }

}

