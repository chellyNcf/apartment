package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.StaySchool;
import com.luoying.apartment.service.IStaySchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Map;

/**
 * <p>
 * 寒暑假留校表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/stay-school")
public class StaySchoolController extends BaseController {

    @Autowired
    private IStaySchoolService staySchoolService;


    @GetMapping("/page")
    public ResultMsg page(@RequestParam Map<String,Object> params){
        MyPage<StaySchool> page=new MyPage<>(params);
        page=staySchoolService.getStaySchoolPage(page);
        ResultMsg msg=ResultMsgFactory.createSuccessMsg(page.getRecords());
        msg.setCount(page.getCount());
        return msg;
    }


    @PostMapping
    public ResultMsg add(@RequestBody  StaySchool staySchool){

        staySchoolService.save(staySchool);
        return ResultMsgFactory.createSuccessMsg();
    }

    @PostMapping("/audit")
    public ResultMsg audit(@RequestBody  StaySchool staySchool){

        staySchoolService.updateById(staySchool);
        return ResultMsgFactory.createSuccessMsg();
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除信息:{}",id);
        staySchoolService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }

}

