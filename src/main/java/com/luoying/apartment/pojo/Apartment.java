package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 公寓表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_apartment")
public class Apartment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 公寓名
     */
    private String apartmentName;

    /**
     * 公寓描述
     */
    private String note;


}
