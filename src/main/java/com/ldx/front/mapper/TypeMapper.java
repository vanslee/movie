package com.ldx.front.mapper;

import com.ldx.front.pojo.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ldx
* @description 针对表【type】的数据库操作Mapper
* @createDate 2022-06-01 10:38:53
* @Entity com.ldx.front.pojo.Type
*/
@Mapper
public interface TypeMapper extends BaseMapper<Type> {
     List<Type> getAllTypes();
}




