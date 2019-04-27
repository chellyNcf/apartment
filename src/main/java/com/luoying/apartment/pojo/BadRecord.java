package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 违规表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_bad_record")
public class BadRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 违规事件
     */
    private String eventContent;

    /**
     * 原因
     */
    private String reason;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 记录人id
     */
    private Long recordUserId;

    /**
     * 处理人id
     */
    private Long handleUserId;

    /**
     * 0未处理，1警告，2处分，3撤销
     */
    private Integer handleStatus;

    /**
     * 处理内容
     */
    private String handle;


}
