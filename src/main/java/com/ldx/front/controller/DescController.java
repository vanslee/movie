package com.ldx.front.controller;

import com.ldx.front.service.TyinfoService;
import com.ldx.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tyinfo")
public class DescController {
    @Autowired
    private TyinfoService tyinfoService;
    @GetMapping("/{tid}")
    public AjaxResult query(@PathVariable Integer tid) {
        return AjaxResult.success(tyinfoService.findByTid(tid));
    }
}
