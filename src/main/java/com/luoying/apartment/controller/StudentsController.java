package com.luoying.apartment.controller;

import com.luoying.apartment.base.bean.ResultMsg;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students/")
public class StudentsController {

    @GetMapping("/page")
    public ResultMsg getStudentsPage(){

        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        msg.setCount(1);
        return msg;
    }
}
