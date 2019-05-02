package com.luoying.apartment.controller;

import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.base.controller.BaseController;
import com.luoying.apartment.pojo.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apartment")
public class LoginController extends BaseController {

    @PostMapping
    public ResultMsg login(@RequestBody User user){

        return ResultMsgFactory.createSuccessMsg();
    }
}
