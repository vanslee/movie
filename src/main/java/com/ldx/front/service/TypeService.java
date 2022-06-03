package com.ldx.front.service;

import com.ldx.front.pojo.Type;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ldx
* @description 针对表【type】的数据库操作Service
* @createDate 2022-06-01 10:38:53
*/
public interface TypeService extends IService<Type> {
     List<Type> findAll();
}
