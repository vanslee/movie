package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Orderitem;
import com.ldx.front.service.OrderitemService;
import com.ldx.front.mapper.OrderitemMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【orderitem】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class OrderitemServiceImpl extends ServiceImpl<OrderitemMapper, Orderitem>
    implements OrderitemService{

}




