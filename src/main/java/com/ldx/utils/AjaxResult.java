package com.ldx.utils;

import lombok.Data;


public class AjaxResult {
    private Integer code;
    private Object data;
    private Boolean success;
    private String msg;

    /**
     * 默认成功
     * @param data
     */
    public AjaxResult(Object data) {
        this.code = 200;
        this.success = true;
        this.msg = "操作成功";
        this.data = data;
    }

    /**
     * 默认失败
     * @param msg
     */
    public AjaxResult(String msg) {
        this.code = 400;
        this.success = false;
        this.msg = msg;
        this.data = null;
    }
    public AjaxResult(String msg,Object data) {
        this.code = 200;
        this.success = true;
        this.msg = msg;
        this.data = data;
    }
    public AjaxResult(int code, Object data, Boolean success, String msg) {
        this.code = code;
        this.data = data;
        this.success = success;
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * 自定义状态码,自定义消息
     * @param data
     * @return
     */
    public static AjaxResult success(Object data) {
        return new AjaxResult(data);
    }
    public static AjaxResult success(String msg,Object data){
        return  new AjaxResult(msg,data);
    }

    /**
     * @param msg 失败消息
     * @return AjaxResult对象
     */
    public static  AjaxResult fail(String msg) {
        return new AjaxResult(msg);
    }

    public AjaxResult setData(Object data) {
        this.data = data;
        return this;
    }
    public AjaxResult setSuccess(Boolean success) {
        this.success = success;
        return this;
    }
    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }


}
