package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tyinfo
 */
@TableName(value ="tyinfo")
@Data
public class Tyinfo implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer tid;

    /**
     * 
     */
    private String type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}