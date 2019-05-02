package com.luoying.apartment.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luoying.apartment.base.bean.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
     * 公寓id
     */
    private Long apartmentId;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回格式
    private Date inTime;

    /**
     * 出库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//接收格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//返回格式
    private Date outTime;

    /**
     * 备注
     */
    private String note;

    /**
     * 种类
     */
    private Long goodCategoryId;

    /**
     * 状态 0存在，1已出库
     */
    private Integer status;


    @TableField(exist = false)
    private String studentName;

    @TableField(exist = false)
    private String dormitoryNum;

    @TableField(exist = false)
    private String apartmentName;

    @TableField(exist = false)
    private String goodCategoryName;

}
