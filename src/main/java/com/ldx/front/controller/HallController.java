package com.ldx.front.controller;

import com.ldx.front.pojo.Hall;
import com.ldx.front.service.HallService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hall")
@Api(tags="影厅接口",value = "影厅接口详细API")
public class HallController {
    @Autowired
    private HallService hallService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询影厅",notes = "分页查询所有影厅")
    public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
        return AjaxResult.success(hallService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询影厅")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(hallService.getById(id));
    }
    /**
     * 添加影厅
     * @param hall
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody Hall hall) {
        if (hall.getId() != null) {
            try {
                return AjaxResult.success(hallService.updateById(hall));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(hallService.save(hall));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 影厅id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "影厅删除接口",notes = "通过id删除影厅")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(hallService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
