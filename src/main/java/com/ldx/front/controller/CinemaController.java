package com.ldx.front.controller;


import com.ldx.front.pojo.Cinema;
import com.ldx.front.service.CinemaService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "电影院接口",tags = "电影院接口的详细API")
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    public CinemaService cinemaService;
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询接口",notes = "分页查询所有电影院")
    public AjaxResult getPages(@PathVariable int pageNum, @PathVariable int pageSize){
        return AjaxResult.success(cinemaService.getPages(pageNum,pageSize));
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "ID查询电影院")
    public AjaxResult getPages(@PathVariable Integer id){
        return AjaxResult.success(cinemaService.getById(id));
    }
    /**
     * 添加电影院
     * @param cinema
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody Cinema cinema) {
        if (cinema.getId() != null) {
            try {
                return AjaxResult.success(cinemaService.updateById(cinema));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(cinemaService.save(cinema));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }

    /**
     * @param id 电影院id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "电影院删除接口",notes = "通过id删除电影院")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(cinemaService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
