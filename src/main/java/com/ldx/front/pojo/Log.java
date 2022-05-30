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
 * @TableName log
 */
@TableName(value ="log")
@Data
public class Log implements Serializable {
    /**
     * 操作id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 操作名
     */
    private String opname;

    /**
     * 操作时间
     */
    private Date optime;

    /**
     * 管理id
     */
    private Integer aid;

    /**
     * 操作人的ip地址
     */
    private String ip;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}