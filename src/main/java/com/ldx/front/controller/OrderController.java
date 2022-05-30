package com.ldx.front.controller;

import com.ldx.front.pojo.Orders;
import com.ldx.front.service.OrdersService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "订单接口",tags = "订单详细接口API")
@RestController
@RequestMapping("/order")
public class OrderController {
        @Autowired
        private OrdersService ordersService;
        @GetMapping("/{pageNum}/{pageSize}")
        @ApiOperation(value = "查询订单",notes = "分页查询所有订单")
        public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
            return AjaxResult.success(ordersService.getPages(pageNum,pageSize));
        }
        @GetMapping("/{id}")
        @ApiOperation(value = "查询接口",notes = "ID查询订单")
        public AjaxResult getPages(@PathVariable Integer id){
            return AjaxResult.success(ordersService.getById(id));
        }
        /**
         * 添加订单
         * @param orders
         * @return
         */
        @PutMapping
        @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
        public AjaxResult save(@RequestBody Orders orders) {
            if (orders.getId() != null) {
                try {
                    return AjaxResult.success(ordersService.updateById(orders));
                } catch (Exception e) {
                    return AjaxResult.fail(e.getMessage());
                }
            }
            try {
                return AjaxResult.success(ordersService.save(orders));
            }catch (Exception e){
                return AjaxResult.fail(e.getMessage());
            }
        }

        /**
         * @param id 订单id
         * @return
         */
        @DeleteMapping("/{id}")
        @ApiOperation(value = "订单删除接口",notes = "通过id删除订单")
        public AjaxResult deleteById(@PathVariable Integer id) {
            try {
                return AjaxResult.success(ordersService.removeById(id));
            }catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
}
