package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.Repairs;
import com.luoying.apartment.dao.RepairsMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.IRepairsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.service.IStudentService;
import com.luoying.apartment.service.UserService;
import com.luoying.apartment.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 报修表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class RepairsServiceImpl extends ServiceImpl<RepairsMapper, Repairs> implements IRepairsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public MyPage<Repairs> getRepairsPage(MyPage<Repairs> page) {
        page.setRecords(this.baseMapper.queryRepairsPage(page.getParams()));
        page.setCount(this.baseMapper.queryRepairsPageCount(page.getParams()));
        return page;
    }

    @Override
    public Repairs getRepairsById(Long id) {
        Repairs repairs = this.baseMapper.queryRepairsById(id);
        return repairs;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addRepairs(Repairs repairs, User user) {
        MyUtil.checkNull(user);
        MyUtil.checkNull(user.getId(),"用户为空");
        Integer sponsorType=repairs.getSponsorType();
        MyUtil.checkNull(sponsorType);
        //学生
        if(sponsorType==0){
            //获取当前登录学生的user信息
            User stu = userMapper.selectById(user.getId());
            MyUtil.checkNull(stu);
            MyUtil.checkNull(stu.getStudentId());
            Student student =  studentMapper.selectById(user.getStudentId());
            //填上报人信息
            repairs.setSponsorId(student.getId());
            repairs.setSponsorName(student.getStudentName());
            repairs.setSponsorPhone(student.getPhone());
            repairs.setDormitoryId(student.getDormitoryId());
        }else if (sponsorType==1){
            repairs.setSponsorId(user.getId());
        }

        this.baseMapper.insert(repairs);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateRepairs(Repairs repairs, User user) {
        MyUtil.checkNull(user);
        MyUtil.checkNull(user.getId(),"用户为空");
        User manager = userMapper.selectById(user.getId());
        MyUtil.checkNull(manager);
        MyUtil.check(manager.getUserType()==0, "账号类型非管理员");
        repairs.setHandleUserId(manager.getId());
        repairs.setStatus(1);
        this.baseMapper.updateById(repairs);
    }
}
