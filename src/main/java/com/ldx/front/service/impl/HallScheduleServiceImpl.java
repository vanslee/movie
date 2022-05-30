package com.ldx.front.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.front.pojo.HallSchedule;
import com.ldx.front.service.HallScheduleService;
import com.ldx.front.mapper.HallScheduleMapper;
import org.springframework.stereotype.Service;

/**
* @author ldx
* @description 针对表【hall_schedule】的数据库操作Service实现
* @createDate 2022-05-27 09:04:53
*/
@Service
public class HallScheduleServiceImpl extends ServiceImpl<HallScheduleMapper, HallSchedule>
    implements HallScheduleService{

    @Override
    public PageInfo getPages(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(()->list());
    }
}




