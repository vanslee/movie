package com.ldx.front.service;

import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ldx
* @description 针对表【orders】的数据库操作Service
* @createDate 2022-05-27 09:04:53
*/
public interface OrdersService extends IService<Orders> {

    PageInfo getPages(int pageNum, int pageSize);
}
