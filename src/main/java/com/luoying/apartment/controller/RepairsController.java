package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Repairs;
import com.luoying.apartment.service.IRepairsService;
import com.luoying.apartment.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 报修表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/repairs")
public class RepairsController extends BaseController {
    @Autowired
    private IRepairsService repairsService;

    @GetMapping("/page")
    public ResultMsg getRepairsPage(@RequestParam Map<String,Object> params){
        logger.info("分页查询报修信息");
        MyPage<Repairs> page = new MyPage<>(params);
        page = repairsService.getRepairsPage(page);
        ResultMsg resultMsg = ResultMsgFactory.createSuccessMsg();
        resultMsg.setData(page.getRecords());
        resultMsg.setCount(page.getCount());
        return resultMsg;
    }

    /**
     * 提交报修申请
     * @param repairs
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody Repairs repairs){
        logger.info("保存报修信息{}",repairs);

        repairsService.addRepairs(repairs,JwtUtil.getUser());
        return ResultMsgFactory.createSuccessMsg();
    }
    @DeleteMapping("/{id}")
    public ResultMsg delete(@PathVariable("id")Long id){
        logger.info("删除报修信息{}",id);
        repairsService.removeById(id);
        return  ResultMsgFactory.createSuccessMsg();
    }
    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id")Long id){
        logger.info("查询报修信息{}",id);
        return ResultMsgFactory.createSuccessMsg(repairsService.getRepairsById(id));
    }

    /**
     * 管理员处理报修申请
     * @param repairs
     * @return
     */
    @PutMapping
    public ResultMsg update(@RequestBody Repairs repairs){
        logger.info("更新报修信息{}",repairs);
        repairs.setUpdateDate(new Date());
        repairsService.updateRepairs(repairs,JwtUtil.getUser());
        return ResultMsgFactory.createSuccessMsg();
    }

}

