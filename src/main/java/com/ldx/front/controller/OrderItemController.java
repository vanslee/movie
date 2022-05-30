package com.ldx.front.controller;

import com.ldx.front.pojo.Orderitem;
import com.ldx.front.service.OrderitemService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "订单项接口",tags = "订单项详细接口API")
@RestController
@RequestMapping("/orders")
public class OrderItemController {
    @Autowired
    private OrderitemService orderitemService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询订单项",notes = "分页查询所有订单项")
    public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
        return AjaxResult.success(orderitemService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询订单项")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(orderitemService.getById(id));
    }
    /**
     * 添加订单项
     * @param orderItem
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody Orderitem orderItem) {
        if (orderItem.getId() != null) {
            try {
                return AjaxResult.success(orderitemService.updateById(orderItem));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(orderitemService.save(orderItem));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 订单项id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "订单项删除接口",notes = "通过id删除订单项")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(orderitemService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
