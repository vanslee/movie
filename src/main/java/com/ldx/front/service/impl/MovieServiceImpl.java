package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Movie;
import com.ldx.front.service.MovieService;
import com.ldx.front.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【movie】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie>
    implements MovieService{

    @Override
    public PageInfo<Object> getPages(int pageNum, int pageSize) {
            return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->list());
    }
}




