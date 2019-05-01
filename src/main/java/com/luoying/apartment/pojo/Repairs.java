package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 报修表
 * </p>
 *
 * @author LuoYing
 * @since 2019-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("tb_repairs")
public class Repairs extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 发起人id
     */
    private Long sponsorId;

    /**
     * 发起人名
     */
    private String sponsorName;

    /**
     * 发起人类型：0学生1管理员2其他
     */
    private Integer sponsorType;

    /**
     * 电话号码
     */
    private String sponsorPhone;

    /**
     * 报修内容
     */
    private String content;

    /**
     * 处理人id
     */
    private Long handleUserId;

    /**
     * 0未处理，1已处理
     */
    private Integer status;

    /**
     * 修理人
     */
    private String repairsName;

    /**
     * 修理人电话
     */
    private String repairsPhone;

    /**
     * 修理日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回格式
    private LocalDateTime repairsDate;

    /**
     * 备注
     */
    private String note;

    /**
     * 宿舍id
     */
    private Long dormitoryId;

    @TableField(exist = false)
    private String dormitoryNum;

    @TableField(exist = false)
    private String building;

    @TableField(exist = false)
    private String handleUserName;
}
