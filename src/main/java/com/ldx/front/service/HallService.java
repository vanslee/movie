package com.ldx.front.service;

import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Hall;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ldx
* @description 针对表【hall】的数据库操作Service
* @createDate 2022-05-27 09:04:53
*/
public interface HallService extends IService<Hall> {

    PageInfo getPages(int pageNum, int pageSize);
}
