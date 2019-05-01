package com.luoying.apartment.service.impl;

import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.dao.BedMapper;
import com.luoying.apartment.dao.DormitoryMapper;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.pojo.Bed;
import com.luoying.apartment.pojo.Dormitory;
import com.luoying.apartment.pojo.RetirementRecord;
import com.luoying.apartment.dao.RetirementRecordMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.service.IRetirementRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 退宿记录表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class RetirementRecordServiceImpl extends ServiceImpl<RetirementRecordMapper, RetirementRecord> implements IRetirementRecordService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private BedMapper bedMapper;

    @Override
    public MyPage<RetirementRecord> getRetirementRecordPage(MyPage<RetirementRecord> page) {

        page.setRecords(this.baseMapper.queryRetirementRecordPage(page.getParams()));
        page.setCount(this.baseMapper.queryRetirementRecordCount(page.getParams()));
        return page;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void addRetirementRecord(RetirementRecord retirementRecord){

        Student student=studentMapper.selectById(retirementRecord.getStudentId());
        student.setStatus(2);
        studentMapper.updateById(student);

        Dormitory dormitory = dormitoryMapper.selectById(retirementRecord.getDormitoryId());
        dormitory.setStatus(0);
        dormitoryMapper.updateById(dormitory);

        Bed bed = bedMapper.selectById(retirementRecord.getBedId());
        bed.setStatus(0);
        bedMapper.updateById(bed);

        retirementRecord.setRetirementDate(new Date());
        this.save(retirementRecord);
    }
}
