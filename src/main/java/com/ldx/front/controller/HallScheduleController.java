package com.ldx.front.controller;

import com.ldx.front.pojo.HallSchedule;
import com.ldx.front.service.HallScheduleService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="排片接口",value = "排片接口详细API")
@RestController
@RequestMapping("/hasch")
public class HallScheduleController {
    @Autowired
    private HallScheduleService hallScheduleService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询排片",notes = "分页查询所有排片")
    public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
        return AjaxResult.success(hallScheduleService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询排片")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(hallScheduleService.getById(id));
    }
    /**
     * 添加排片
     * @param hall
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody HallSchedule hall) {
        if (hall.getId() != null) {
            try {
                return AjaxResult.success(hallScheduleService.updateById(hall));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(hallScheduleService.save(hall));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 排片id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "排片删除接口",notes = "通过id删除排片")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(hallScheduleService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
