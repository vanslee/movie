package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Admin;
import com.ldx.front.service.AdminService;
import com.ldx.front.mapper.AdminMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【admin】的数据库操作Service实现
* @createDate 2022-05-27 09:04:52
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService{

}




