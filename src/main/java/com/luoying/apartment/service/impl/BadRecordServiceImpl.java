package com.luoying.apartment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.BadRecord;
import com.luoying.apartment.dao.BadRecordMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.IBadRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 违规表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class BadRecordServiceImpl extends ServiceImpl<BadRecordMapper, BadRecord> implements IBadRecordService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public MyPage<BadRecord> getBadRecordPage(MyPage<BadRecord> page) {
        page.setRecords(this.baseMapper.queryBadRecordPage(page.getParams()));
        page.setCount(this.baseMapper.queryBadRecordCount(page.getParams()));
        return page;
    }

    @Override
    public BadRecord getBadRecordById(Long id) {
        return this.baseMapper.queryBadRecordById(id);
    }

    @Override
    public void saveBadRecord(BadRecord badRecord, User user) {
        MyUtil.checkNull(user);
        //添加记录者
        MyUtil.checkNull(user.getId(),"用户为空");
        User currentUser = userMapper.selectById(user.getId());
        MyUtil.checkNull(currentUser);
        badRecord.setRecordUserId(currentUser.getId());
        badRecord.setRecordUserName(currentUser.getUsername());
        this.baseMapper.insert(badRecord);
    }

    @Override
    public void updateBadRecord(BadRecord badRecord, User user) {
        MyUtil.checkNull(user);
        MyUtil.checkNull(user.getId(),"用户为空");
        User currentUser = userMapper.selectById(user.getId());
        MyUtil.checkNull(currentUser);
        badRecord.setHandleUserId(currentUser.getId());
        badRecord.setHandleUserName(currentUser.getUsername());
        this.baseMapper.updateById(badRecord);
    }
}
