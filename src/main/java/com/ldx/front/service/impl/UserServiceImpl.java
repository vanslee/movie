package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.User;
import com.ldx.front.service.UserService;
import com.ldx.front.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public PageInfo getPages(int pageNum, int pageSize) {
      return   PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->list());
    }
}




