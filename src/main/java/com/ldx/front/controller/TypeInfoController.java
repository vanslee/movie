package com.ldx.front.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ldx.front.pojo.Tyinfo;
import com.ldx.front.service.TyinfoService;
import com.ldx.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class TypeInfoController {
    @Autowired
    private TyinfoService tyinfoService;
    @GetMapping
    public AjaxResult getAll() {
        return AjaxResult.success(tyinfoService.list(new QueryWrapper<Tyinfo>().select("type").eq("tid",1)));
    }
}
