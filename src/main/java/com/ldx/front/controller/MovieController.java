package com.ldx.front.controller;


import com.ldx.front.pojo.Movie;
import com.ldx.front.service.MovieService;
import com.ldx.utils.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@Api(tags = "电影接口", value = "电影接口详细API")
public class MovieController {
    @Autowired
    private MovieService movieService;
    /**
     * @param pageNum  页码
     * @param pageSize   页面数据
     * @return
     */
    @GetMapping("/{pageNum}/{pageSize}")
    @ApiOperation(value = "查询接口",notes = "分页查询")
    public AjaxResult getAll( @PathVariable int pageNum, @PathVariable int pageSize) {
        return AjaxResult.success(movieService.getPages(pageNum, pageSize));
    }

    /**
     * @param id        通过id查询电影
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查询接口",notes = "传入id为-1进行分页查询,不为-1进行单条查询")
    public AjaxResult getByID(@PathVariable Integer id ) {
        return AjaxResult.success(movieService.getById(id));
    }
    /**
     * 添加电影
     * @param movie
     * @return
     */
    @PutMapping
    @ApiOperation(value = "添加或更新接口",notes = "根据传入数据有无id增改数据")
    public AjaxResult save(@RequestBody Movie movie) {
        if (movie.getId() != null) {
            try {
                return AjaxResult.success(movieService.updateById(movie));
            } catch (Exception e) {
                return AjaxResult.fail(e.getMessage());
            }
        }
        try {
            return AjaxResult.success(movieService.save(movie));
        }catch (Exception e){
            return AjaxResult.fail(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "电影删除接口",notes = "通过id删除电影")
    public AjaxResult deleteById(@PathVariable Integer id) {
        try {
            return AjaxResult.success(movieService.removeById(id));
        }catch (Exception e) {
            return AjaxResult.fail(e.getMessage());
        }
    }
}
