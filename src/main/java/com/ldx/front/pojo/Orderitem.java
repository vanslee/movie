package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 
 * @TableName orderitem
 */
@TableName(value ="orderitem")
@Data
public class Orderitem implements Serializable {
    /**
     * 订单项id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 电影id
     */
    private Integer mid;

    /**
     * 所属订单id
     */
    private Integer oid;

    /**
     * 购买总数
     */
    private Integer buycount;

    /**
     * 座位情况
     */
    private String seatinfo;

    /**
     * 订单项价格
     */
    private BigDecimal price;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}