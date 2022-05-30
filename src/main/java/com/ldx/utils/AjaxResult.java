package com.ldx.utils;

import lombok.Data;

@Data
public class AjaxResult {
    private Object data;
    private Boolean success;
    private String msg;
}
