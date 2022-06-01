package com.ldx.front.controller;

import com.ldx.front.service.TypeService;
import com.ldx.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type")
public class TypeController {
    @Autowired
    public TypeService typeService;
    @GetMapping
    public AjaxResult query() {
        return AjaxResult.success(typeService.list());
    }
}
