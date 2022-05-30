package com.ldx.front.service;

import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ldx
* @description 针对表【user】的数据库操作Service
* @createDate 2022-05-27 09:04:53
*/
public interface UserService extends IService<User> {

    PageInfo getPages(int pageNum, int pageSize);
}
