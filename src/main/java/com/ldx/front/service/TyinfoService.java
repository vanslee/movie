package com.ldx.front.service;

import com.ldx.front.pojo.Tyinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ldx
* @description 针对表【tyinfo】的数据库操作Service
* @createDate 2022-06-01 10:41:57
*/
public interface TyinfoService extends IService<Tyinfo> {

    List<Tyinfo> findByTid(Integer tid);
}
