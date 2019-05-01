package com.luoying.apartment.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.luoying.apartment.base.bean.ResultMsg;
import com.luoying.apartment.base.bean.ResultMsgFactory;
import com.luoying.apartment.service.IGoodCategoryService;
import com.luoying.apartment.service.IGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luoying.apartment.base.controller.BaseController;

/**
 * <p>
 * 大件物品种类表 前端控制器
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@RestController
@RequestMapping("/apartment/good-category")
public class GoodCategoryController extends BaseController {
    @Autowired
    private IGoodCategoryService goodCategoryService;

    @GetMapping("/{id}")
    public ResultMsg get(@PathVariable("id") Long id) {
        logger.info("查询大宗物品信息{}", id);
        return ResultMsgFactory.createSuccessMsg(goodCategoryService.getById(id));
    }

    /**
     * 获取全部大宗物品种类
     * @return
     */
    @GetMapping("/list")
    public ResultMsg getGoodCateList(){
        logger.info("查询大宗物品列表");
        return ResultMsgFactory.createSuccessMsg(goodCategoryService.list());
    }

}

