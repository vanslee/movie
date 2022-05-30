package com.ldx.front.controller;

import com.ldx.front.pojo.Admin;
import com.ldx.front.pojo.Movie;
import com.ldx.front.service.AdminService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags="后台管理员接口",value = "管理员接口详细API")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询接口",notes = "分页查询所有管理员")
    public AjaxResult getPages(@PathVariable int pageNum,@PathVariable int pageSize){
        return AjaxResult.success(adminService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询管理员")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(adminService.getById(id));
    }
    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody Admin admin) {
        if (admin.getId() != null) {
            try {
                return AjaxResult.success(adminService.updateById(admin));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(adminService.save(admin));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 管理员id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "管理员删除接口",notes = "通过id删除管理员")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(adminService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
