package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * 
 * @TableName movie
 */
@TableName(value ="movie")
@Data
public class Movie implements Serializable {
    /**
     * 影片id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 影片名称
     */
    private String name;

    /**
     * 副标题
     */
    private String title;

    /**
     * 影片类型
     */
    private String mtype;
    /**
     * 年份
     */
    private String year;

    /**
     * 上映地区
     */
    private String area;

    /**
     * 上映日期
     */
    private Date publishdate;

    /**
     * 评分
     */
    private Double rating;

    /**
     * 导演，多个之间使用","分割
     */
    private String director;

    /**
     * 演员，多个之间使用","分割
     */
    private String actor;

    /**
     * 影片介绍
     */
    private String summary;

    /**
     * 封面图
     */
    private String pic;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}