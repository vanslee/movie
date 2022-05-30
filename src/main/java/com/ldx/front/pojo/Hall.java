package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName hall
 */
@TableName(value ="hall")
@Data
public class Hall implements Serializable {
    /**
     * 影厅id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 影厅名
     */
    private String name;

    /**
     * 影厅类型
     */
    private String htype;

    /**
     * 座位情况(二维数组)
     */
    private String seats;

    /**
     * 影厅状态 0-未使用 1-使用中 2-维护中
     */
    private Integer status;

    /**
     * 影院id
     */
    private Integer cid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}