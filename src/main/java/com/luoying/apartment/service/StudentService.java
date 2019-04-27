package com.luoying.apartment.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.pojo.Student;

import java.util.List;

public interface StudentService extends IService<Student> {

    public MyPage<Student> getStudentPage(MyPage<Student> page);
}
