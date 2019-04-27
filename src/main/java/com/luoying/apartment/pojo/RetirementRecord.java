package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 退宿记录表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_retirement_record")
public class RetirementRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 退宿原因
     */
    private String reason;

    /**
     * 退宿日期
     */
    private LocalDateTime retirementDate;

    /**
     * 床位id
     */
    private Long bedId;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 学生id
     */
    private Long studentId;


}
