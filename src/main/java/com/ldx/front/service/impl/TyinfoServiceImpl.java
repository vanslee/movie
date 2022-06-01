package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Tyinfo;
import com.ldx.front.service.TyinfoService;
import com.ldx.front.mapper.TyinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author ldx
* @description 针对表【tyinfo】的数据库操作Service实现
* @createDate 2022-06-01 10:41:57
*/
@Service
public class TyinfoServiceImpl extends ServiceImpl<TyinfoMapper, Tyinfo>
    implements TyinfoService{
@Autowired
private TyinfoMapper tyinfoMapper;
    @Override
    public List<Tyinfo> findByTid(Integer tid) {
        return tyinfoMapper.getByTid(tid);
    }
}




