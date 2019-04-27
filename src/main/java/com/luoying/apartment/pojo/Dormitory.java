package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 宿舍表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_dormitory")
public class Dormitory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 宿舍房号
     */
    private String dormitoryNum;

    /**
     * 公寓id
     */
    private String apartmentId;

    /**
     * 第几栋
     */
    private String building;

    /**
     * 宿舍描述
     */
    private String note;

    /**
     * 公寓名
     */
    @TableField(exist = false)
    private String apartmentName;


}
