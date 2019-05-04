package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.config.ApartmentConfig;
import com.luoying.apartment.base.constant.UserTypeEnum;
import com.luoying.apartment.dao.BedMapper;
import com.luoying.apartment.dao.DormitoryMapper;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.IStudentService;
import com.luoying.apartment.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BedMapper bedMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private ApartmentConfig apartmentConfig;

    @Override
    public MyPage<Student> getStudentPage(MyPage<Student> page) {
        page.setRecords(this.baseMapper.queryStudentPage( page.getParams()));
        page.setCount(this.baseMapper.queryStudentCount(page.getParams()));
        return page;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void saveStudent(Student student) {

        Student queryStudent=new Student();
        queryStudent.setStudentNum(student.getStudentNum());
        int count = this.baseMapper.selectCount(new QueryWrapper<>(queryStudent));
        MyUtil.check(count==0, "该学号已存在");

        student.setStatus(0);
        save(student);

        User user=new User();
        user.setStudentId(student.getId());
        user.setUsername(student.getStudentNum());
        user.setUserType(UserTypeEnum.NORMAL_USER.getValue());
        user.setPassword(MyUtil.pwdMd5(student.getPassword()));
        userMapper.insert(user);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void dormitory(Student student) {
        Long bedId=student.getBedId();
        Long dormitoryId = student.getDormitoryId();
        MyUtil.checkNull(bedId);
        MyUtil.checkNull(dormitoryId);
        MyUtil.checkNull(student.getId());

        Bed bed=bedMapper.selectById(bedId);
        MyUtil.checkNull(bed,"该床位不存在");
        MyUtil.check(bed.getStatus()==0, "床位已被其他人使用");
        bed.setStatus(1);//占用
        bed.setUpdateDate(new Date());
        bedMapper.updateById(bed);


        Dormitory dormitory = dormitoryMapper.selectById(dormitoryId);
        MyUtil.checkNull(dormitory,"该宿舍不存在");
        Bed queryBed=new Bed();
        queryBed.setDormitoryId(student.getDormitoryId());
        queryBed.setStatus(0);
        int count=bedMapper.selectCount(new QueryWrapper<>(queryBed));
        if(count==0){
            dormitory.setStatus(1);
        }
        dormitory.setUpdateDate(new Date());
        dormitoryMapper.updateById(dormitory);

        student.setStatus(1);//已入住
        student.setUpdateDate(new Date());
        updateById(student);
    }

    @Override
    public Student getStudentDetail(Student student) {

        return this.baseMapper.queryStudentInfo(student);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void uploadPhoto(MultipartFile multipartFile, Integer id) {

        MyUtil.check(!multipartFile.isEmpty(), "文件为空");

        Student student=getById(id);
        MyUtil.checkNull(student);

        String fileName = multipartFile.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath="images/";
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        filePath=filePath + fileName;
        student.setPhotoImgUrl(filePath);
        updateById(student);

        File file = new File(apartmentConfig.getFilePath()+filePath);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            MyUtil.checkFailed(e.getMessage());
        }

    }
}
