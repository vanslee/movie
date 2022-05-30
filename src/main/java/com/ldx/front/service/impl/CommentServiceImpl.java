package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ldx.front.pojo.Comment;
import com.ldx.front.service.CommentService;
import com.ldx.front.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2022-05-27 09:04:52
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




