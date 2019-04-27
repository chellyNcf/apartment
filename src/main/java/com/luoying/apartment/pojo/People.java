package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 外访人员表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_people")
public class People extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String peopleName;

    /**
     * 电话号码
     */
    private String peoplePhone;

    /**
     * 被访学生
     */
    private Long studentId;

    /**
     * 与被访者关系
     */
    private String relationship;

    /**
     * 原因
     */
    private String reason;

    /**
     * 备注
     */
    private String note;


}
