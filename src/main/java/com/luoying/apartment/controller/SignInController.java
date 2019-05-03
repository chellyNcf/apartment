package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.service.ISignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.luoying.apartment.base.controller.BaseController;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/upload")
    public ResultMsg upload(@RequestParam("file") MultipartFile multipartFile){
        logger.info("上传学生头像:{}",multipartFile.getOriginalFilename());
//        Student student=new Student();
//        student.setId(id);
        return ResultMsgFactory.createSuccessMsg();
    }

}

