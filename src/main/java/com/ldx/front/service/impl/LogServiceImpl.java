package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Log;
import com.ldx.front.service.LogService;
import com.ldx.front.mapper.LogMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【log】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log>
    implements LogService{

}




