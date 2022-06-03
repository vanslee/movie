package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Type;
import com.ldx.front.service.TypeService;
import com.ldx.front.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ldx
 * @description 针对表【type】的数据库操作Service实现
 * @createDate 2022-06-01 10:38:53
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    public List<Type> findAll() {
        return typeMapper.getAllTypes();
    }
}




