package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName cinema
 */
@TableName(value ="cinema")
@Data
public class Cinema implements Serializable {
    /**
     * 影院id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 影院名
     */
    private String name;

    /**
     * 影院品牌
     */
    private String brand;

    /**
     * 影院地址
     */
    private String address;

    /**
     * 影院电话
     */
    private String tel;

    /**
     * 行政区
     */
    private String area;

    /**
     * 是否可改签  0-否 1-是
     */
    private Integer services;

    /**
     * 影院图片
     */
    private String pic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}