package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Orders;
import com.ldx.front.service.OrdersService;
import com.ldx.front.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




