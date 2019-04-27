package com.luoying.apartment.base.controller;

import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.base.exception.MyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionController extends BaseController{

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
    }

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResultMsg errorHandler(Exception e) {
        logger.error("统一异常处理", e);
        //正式生产环境需要屏蔽数据库异常，这里开发环境直接返回所有异常信息
        return ResultMsgFactory.createErrorMsg("系统错误："+e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MyException.class)
    public ResultMsg myErrorHandler(MyException e){
        logger.warn("业务异常", e);
        return ResultMsgFactory.createErrorMsg(e.getMessage());
    }

}
