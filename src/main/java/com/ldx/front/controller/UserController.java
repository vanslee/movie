package com.ldx.front.controller;

import com.ldx.front.pojo.User;
import com.ldx.front.service.UserService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(value = "会员接口",tags = "会员详细接口API")
@RestController
@RequestMapping("/user ")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询会员",notes = "分页查询所有会员")
    public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
        return AjaxResult.success(userService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询会员")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(userService.getById(id));
    }
    /**
     * 添加会员
     * @param user
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody User user) {
        if (user.getId() != null) {
            try {
                return AjaxResult.success(userService.updateById(user));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(userService.save(user));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 会员id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "会员删除接口",notes = "通过id删除会员")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(userService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
