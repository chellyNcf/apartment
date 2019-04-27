package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 大件物品表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_good")
public class Good extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 物品名
     */
    private String goodName;

    /**
     * 公寓名
     */
    private String apartmentName;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 入库时间
     */
    private LocalDateTime inTime;

    /**
     * 出库时间
     */
    private LocalDateTime outTime;

    /**
     * 备注
     */
    private String note;


}
