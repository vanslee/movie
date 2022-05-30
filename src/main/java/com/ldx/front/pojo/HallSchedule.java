package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName hall_schedule
 */
@TableName(value ="hall_schedule")
@Data
public class HallSchedule implements Serializable {
    /**
     * 排片id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 影片id
     */
    private Integer mid;

    /**
     * 影厅id
     */
    private Integer hid;

    /**
     * 座位状态
     */
    private String seats;

    /**
     * 票价
     */
    private BigDecimal price;

    /**
     * 开始时间
     */
    private Date starttime;

    /**
     * 结束时间
     */
    private Date endtime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}