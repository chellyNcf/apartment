package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

    @Override
    public MyPage<Student> getStudentPage(MyPage<Student> page) {

        page.setRecords(this.baseMapper.queryStudentPage( page.getParams()));
        page.setCount(this.baseMapper.queryStudentCount(page.getParams()));
        return page;
    }
}
