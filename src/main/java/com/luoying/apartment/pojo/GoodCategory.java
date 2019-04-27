package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 大件物品种类表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_good_category")
public class GoodCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 种类名
     */
    private String goodCategoryName;

    /**
     * 种类类型值
     */
    private String goodCategoryType;


}
