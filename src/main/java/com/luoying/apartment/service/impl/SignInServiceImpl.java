package com.luoying.apartment.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.luoying.apartment.base.bean.MyPage;
import com.luoying.apartment.base.config.ApartmentConfig;
import com.luoying.apartment.dao.StudentMapper;
import com.luoying.apartment.dao.UserMapper;
import com.luoying.apartment.pojo.SignIn;
import com.luoying.apartment.dao.SignInMapper;
import com.luoying.apartment.pojo.Student;
import com.luoying.apartment.pojo.User;
import com.luoying.apartment.service.ISignInService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luoying.apartment.utils.FaceMatchUtil;
import com.luoying.apartment.utils.JwtUtil;
import com.luoying.apartment.utils.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * <p>
 * 签到表 服务实现类
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Service
public class SignInServiceImpl extends ServiceImpl<SignInMapper, SignIn> implements ISignInService {

    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ApartmentConfig apartmentConfig;


    @Override
    public MyPage<SignIn> getSignInPage(MyPage<SignIn> page) {

        page.setRecords(this.baseMapper.querySignInPage(page.getParams()));
        page.setCount(this.baseMapper.querySignInCount(page.getParams()));
        return page;
    }

    @Override
    public void signIn(MultipartFile multipartFile) {

        User user=JwtUtil.getUser();

        user=userMapper.selectById(user.getId());
        Student student=studentMapper.selectById(user.getStudentId());
        MyUtil.checkNull(student.getPhotoImgUrl(),"你还未上传照片");
        String path=apartmentConfig.getFilePath()+student.getPhotoImgUrl();
        String result=null;
        try {
            result=FaceMatchUtil.match(path, multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            MyUtil.checkFailed(e.getMessage());
        }
        if(StringUtils.isEmpty(result)){
            MyUtil.checkFailed("签到失败");
        }

        SignIn signIn=new SignIn();
        signIn.setSignInType(0);
        signIn.setDormitoryId(student.getDormitoryId());
        signIn.setStudentId(student.getId());

        Gson gson =new Gson();
        Map<String,Object> objectMap=gson.fromJson(result,Map.class );
        int code=MyUtil.getInt(objectMap.get("error_code"));
        if(code!=0){
            signIn.setSuccess(0);
            save(signIn);
            MyUtil.checkFailed(objectMap.get("error_msg").toString());
        }
        logger.info("{}-人脸识别结果：{}",student.getStudentName(), objectMap.get("result"));
        signIn.setSuccess(1);
        save(signIn);
    }
}
