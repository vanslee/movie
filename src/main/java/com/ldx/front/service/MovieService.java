package com.ldx.front.service;

import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Movie;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ldx
* @description 针对表【movie】的数据库操作Service
* @createDate 2022-05-27 09:04:53
*/
public interface MovieService extends IService<Movie> {
        PageInfo<Movie> getPages(int pageNum,int pageSize);
}
