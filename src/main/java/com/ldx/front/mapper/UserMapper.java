package com.ldx.front.mapper;

import com.ldx.front.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ldx
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-05-27 09:04:53
* @Entity com.ldx.font.pojo.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
}




