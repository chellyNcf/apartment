package com.luoying.apartment.controller;

import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.base.controller.BaseController;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 */
@RestController
@RequestMapping("/apartment/user")
public class UserController extends  BaseController{

    @Autowired
    private UserService userService;

    /**
     * 添加
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody User user){
        logger.info("保存用户信息:{}",user);
        userService.save(user);
        return ResultMsgFactory.createSuccessMsg();
    }

    /**
     * 更新
     * @return
     */
    @PutMapping
    public ResultMsg update(@RequestBody User user){
        logger.info("更新用户信息:{}",user);
        userService.updateById(user);
        return ResultMsgFactory.createSuccessMsg();
    }

    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id){
        logger.info("查询用户信息:{}",id);

        return ResultMsgFactory.createSuccessMsg(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除用户信息:{}",id);
        userService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }
}
