package com.ldx.front.controller;

import com.ldx.front.pojo.Comment;
import com.ldx.front.service.CommentService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@Api(tags="评论接口",value = "评论接口详细API")
public class CommentController {
        @Autowired
        private CommentService commentService;
        @GetMapping("/{pageNum}/{pageSize}")
        @ApiOperation(value = "查询评论",notes = "分页查询所有评论")
        public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
            return AjaxResult.success(commentService.getPages(pageNum,pageSize));
        }
        @GetMapping("/{id}")
        @ApiOperation(value = "查询接口",notes = "ID查询评论")
        public AjaxResult getPages(@PathVariable Integer id){
            return AjaxResult.success(commentService.getById(id));
        }
        /**
         * 添加评论
         * @param comment
         * @return
         */
        @PutMapping
        @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
        public AjaxResult save(@RequestBody Comment comment) {
            if (comment.getId() != null) {
                try {
                    return AjaxResult.success(commentService.updateById(comment));
                } catch (Exception e) {
                    return AjaxResult.fail(e.getMessage());
                }
            }
            try {
                return AjaxResult.success(commentService.save(comment));
            }catch (Exception e){
                return AjaxResult.fail(e.getMessage());
            }
        }

        /**
         * @param id 评论id
         * @return
         */
        @DeleteMapping("/{id}")
        @ApiOperation(value = "评论删除接口",notes = "通过id删除评论")
        public AjaxResult deleteById(@PathVariable Integer id) {
            try {
                return AjaxResult.success(commentService.removeById(id));
            }catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
    }
