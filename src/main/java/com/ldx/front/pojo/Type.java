package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName type
 */
@TableName(value ="type")
@Data
public class Type implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 类型
     */
    private String typeinfo;

    /**
     * 详情
     */
    private Integer did;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    // 存放Tyinfo表信息
    @TableField(exist = false)
    private List<Tyinfo> typeDetail;
}