package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Cinema;
import com.ldx.front.service.CinemaService;
import com.ldx.front.mapper.CinemaMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【cinema】的数据库操作Service实现
* @createDate 2022-05-27 09:04:52
*/
@Service
public class CinemaServiceImpl extends ServiceImpl<CinemaMapper, Cinema>
    implements CinemaService{

    @Override
    public PageInfo getPages(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->list());
    }
}




