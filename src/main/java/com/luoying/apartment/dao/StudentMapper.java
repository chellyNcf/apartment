package com.luoying.apartment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentMapper extends BaseMapper<Student> {

    List<Student> queryStudentPage(Map<String,Object> params);

    int queryStudentCount(Map<String,Object> params);

    Student queryStudentInfo(Student student);

}
