package com.ldx.front.mapper;

import com.ldx.front.pojo.Tyinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ldx
* @description 针对表【tyinfo】的数据库操作Mapper
* @createDate 2022-06-01 10:41:57
* @Entity com.ldx.front.pojo.Tyinfo
*/
@Mapper
public interface TyinfoMapper extends BaseMapper<Tyinfo> {

    List<Tyinfo> getByTid(Integer tid);
}




