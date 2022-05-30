package com.ldx.front.controller;

import com.ldx.front.pojo.Admin;
import com.ldx.front.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="管理接口",description = "管理员接口API")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin")
    @ApiOperation(value = "获取管理员",notes = "获取所有管理员")
    public List<Admin> getAll(){
        List<Admin> list = adminService.list();
        return list;
    }
}
