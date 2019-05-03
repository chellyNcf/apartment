package com.luoying.apartment.service;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 学生表 服务类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
public interface IStudentService extends IService<Student> {

    MyPage<Student> getStudentPage(MyPage<Student> page);

    void saveStudent(Student student);

    void dormitory(Student student);

    Student getStudentDetail(Student student);

}
