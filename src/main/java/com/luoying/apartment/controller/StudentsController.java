package com.luoying.apartment.controller;

import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Vector;

@RestController
@RequestMapping("/students")
public class StudentsController {

   protected static Logger logger= LoggerFactory.getLogger(StudentsController.class);

   private List<Student> students;

   @PostConstruct
   void test(){
       students=new Vector<>();
       Student student;
       for (int i=0;i<25;i++){
           student=new Student();
           students.add(student);
       }
   }

    /**
     * 分页查询
     * @param params
     * @return
     */
    @GetMapping("/page")
    public ResultMsg getStudentsPage(@RequestParam Map<String,Object> params){

        int limit=getInt(params.get("limit"));
        int length=students.size();
        if(limit>length)limit=length;
        Student student;
        List<Student> students=this.students.subList(0, limit);
        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        msg.setCount(length);
        msg.setData(students);
        return msg;
    }
    private int getInt(Object obj){
        if(null!=obj){
            return Integer.valueOf(obj.toString());
        }
        return 10;
    }

    /**
     * 添加
     * @return
     */
    @PostMapping
    public ResultMsg add(@RequestBody Student student){
        logger.info("保存学生信息:{}",student);
        students.add(student);
        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        return msg;
    }

    /**
     * 更新
     * @return
     */
    @PutMapping
    public ResultMsg update(@RequestBody Student student){
        logger.info("更新学生信息:{}",student);
        students.add(student);
        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        return msg;
    }

    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id){
        logger.info("查询学生信息:{}",id);
        int i=id.intValue()-1;

        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        msg.setData(students.get(i));
        return msg;
    }

    @DeleteMapping("/{id}")
    public ResultMsg remove(@PathVariable("id") Long id){
        logger.info("删除学生信息:{}",id);
        int i=id.intValue()-1;
        students.remove(i);
        ResultMsg msg=new ResultMsg();
        msg.setCode(0);
        return msg;
    }
}
