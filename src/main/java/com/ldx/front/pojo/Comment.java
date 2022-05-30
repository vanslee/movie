package com.ldx.front.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private Date ctime;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 影片id
     */
    private Integer mid;

    /**
     * 评分数 (0.0~5.0)
     */
    private Double rating;

    /**
     * 点赞数
     */
    private Integer fav;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}