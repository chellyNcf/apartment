package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.SignIn;
import com.luoying.apartment.service.ISignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * <p>
 * 签到表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/sign-in")
public class SignInController extends BaseController {

    @Autowired
    private ISignInService signInService;

    @GetMapping("/page")
    public ResultMsg page(@RequestParam Map<String,Object> params){

        MyPage<SignIn> page=new MyPage<>(params);

        page=signInService.getSignInPage(page);
        ResultMsg msg=ResultMsgFactory.createSuccessMsg(page.getRecords());
        msg.setCount(page.getCount());
        return msg;
    }

    @PostMapping("/upload")
    public ResultMsg upload(@RequestParam("file") MultipartFile multipartFile){
        logger.info("上传学生头像:{}",multipartFile.getOriginalFilename());
        signInService.signIn(multipartFile);
        return ResultMsgFactory.createSuccessMsg();
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除信息:{}",id);
        signInService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }

}

