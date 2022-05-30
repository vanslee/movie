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
 * @TableName orders
 */
@TableName(value ="orders")
@Data
public class Orders implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 订单号
     */
    private Integer ordernum;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 最后修改时间
     */
    private Date lasttime;

    /**
     * 订单状态 0-未支付  1-已支付  2-退款中  3-已完成
     */
    private Integer status;

    /**
     * 订单总价
     */
    private BigDecimal price;

    /**
     * 用户id
     */
    private Integer uid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}