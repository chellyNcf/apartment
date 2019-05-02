package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.People;
import com.luoying.apartment.service.IPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.luoying.apartment.base.controller.BaseController;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 外访人员表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/people")
public class PeopleController extends BaseController {
    @Autowired
    private IPeopleService peopleService;

    /**
     * 分页查询
     * @param params
     * @return
     */
    @GetMapping("/page")
    public ResultMsg getPeoplesPage(@RequestParam Map<String,Object> params){
        MyPage<People> page = new MyPage<>(params);
        page = peopleService.getPeoplePage(page);
        ResultMsg msg = ResultMsgFactory.createSuccessMsg(page.getRecords());
        msg.setCount(page.getCount());
        return msg;
    }

    /**
     * 添加外访人员
     * @param people
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody People people){
        logger.info("保存外访人员信息:{}",people);
        peopleService.save(people);
        return ResultMsgFactory.createSuccessMsg();
    }

    /**
     * 更新外访人员
     * @param people
     * @return
     */
    @PutMapping
    public ResultMsg update(@RequestBody People people){
        logger.info("更新外访人员信息:{}",people);
        people.setUpdateDate(new Date());
        peopleService.updateById(people);
        return ResultMsgFactory.createSuccessMsg();
    }

    /**
     * 查询外访人员
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id){
        logger.info("查询外访人员信信息:{}",id);
        return ResultMsgFactory.createSuccessMsg(peopleService.getById(id));
    }

    /**
     * 删除外访人员
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        logger.info("删除外访人员信息:{}",id);
        peopleService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }
}

