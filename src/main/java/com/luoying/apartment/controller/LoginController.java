package com.luoying.apartment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.base.constant.Constant;
import com.luoying.apartment.base.controller.BaseController;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.UserService;
import com.luoying.apartment.utils.JwtUtil;
import com.luoying.apartment.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment")
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResultMsg login(@RequestBody User user){

        String password=user.getPassword();
        String username=user.getUsername();
        MyUtil.check(!StringUtils.isEmpty(username), "用户名不能为空");
        MyUtil.check(!StringUtils.isEmpty(password), "密码不能为空");

        user.setPassword(MyUtil.pwdMd5(password));
        user=userService.getOne(new QueryWrapper<>(user));

        MyUtil.checkNull(user,"用户名或密码错误");

        String token=JwtUtil.createJson(user, Constant.AUDIENCE, Constant.ISSUER, Constant.TTLMILLIS, Constant.BASE64_SECURITY);
        User user1=new User();
        user1.setUsername(user.getUsername());
        user1.setStudentId(user.getStudentId());
        user1.setUserType(user.getUserType());
        user1.setToken(token);
        return ResultMsgFactory.createSuccessMsg(user1);
    }
}
