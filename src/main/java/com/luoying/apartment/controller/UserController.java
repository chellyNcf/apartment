package com.luoying.apartment.controller;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.base.controller.BaseController;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户
 */
@RestController
@RequestMapping("/apartment/user")
public class UserController extends  BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public ResultMsg page(@RequestParam Map<String,Object> params){
        MyPage<User> page=new MyPage<>(params);
        page = userService.getUserPage(page);
        ResultMsg msg=ResultMsgFactory.createSuccessMsg(page.getRecords());
        msg.setCount(page.getCount());
        return msg;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody User user){
        logger.info("保存用户信息:{}",user);
        userService.addUser(user);
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

        return ResultMsgFactory.createSuccessMsg(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除用户信息:{}",id);
        userService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }

    @PutMapping("/pwd")
    public ResultMsg updatePwd(String password,String newPassword,String confirmPassword){

        userService.updatePwd(password, newPassword, confirmPassword);
        return ResultMsgFactory.createSuccessMsg();
    }
}
