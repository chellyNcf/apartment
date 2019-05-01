package com.luoying.apartment.controller;


import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

import java.util.Map;

/**
 * <p>
 * 学生表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/student")
public class StudentController extends BaseController {


    @Autowired
    private IStudentService studentService;

    /**
     * 分页查询
     * @param params
     * @return
     */
    @GetMapping("/page")
    public ResultMsg getStudentsPage(@RequestParam Map<String,Object> params){

        MyPage<Student> page=new MyPage<>(params);
        page=studentService.getStudentPage(page);
        ResultMsg msg=ResultMsgFactory.createSuccessMsg(page.getRecords());
        msg.setCount(page.getCount());
        return msg;
    }


    /**
     * 添加
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody Student student){
        logger.info("保存学生信息:{}",student);
        studentService.saveStudent(student);
        return ResultMsgFactory.createSuccessMsg();
    }

    /**
     * 更新
     * @return
     */
    @PutMapping
    public ResultMsg update(@RequestBody Student student){
        logger.info("更新学生信息:{}",student);
        studentService.updateById(student);
        return ResultMsgFactory.createSuccessMsg();
    }

    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id){
        logger.info("查询学生信息:{}",id);

        return ResultMsgFactory.createSuccessMsg(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除学生信息:{}",id);
        studentService.removeById(id);
        return ResultMsgFactory.createSuccessMsg();
    }

    /**
     * 入住宿舍
     * @return
     */
    @PostMapping("/dormitory")
    public ResultMsg dormitory(@RequestBody Student student){
        logger.info("学生入住:{}",student);
        studentService.dormitory(student);
        return ResultMsgFactory.createSuccessMsg();
    }

}

