package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.Admin;
import com.ldx.front.service.AdminService;
import com.ldx.front.mapper.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
* @author ldx
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-05-27 09:04:52
*/
@Service
//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true) 查
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{
    @Override
    public PageInfo getPages(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->list());
    }
//@Transactional(propagation = Propagation.REQUIRED,readOnly = false) 写

}




