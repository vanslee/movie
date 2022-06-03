package com.ldx.front.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldx.dto.UserDTO;
import com.ldx.front.pojo.User;
import com.ldx.front.service.UserService;
import com.ldx.front.mapper.UserMapper;
import com.ldx.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static cn.hutool.core.bean.BeanUtil.beanToMap;
import static com.ldx.utils.RedisConstants.LOGIN_TOKEN_TTL;
import static com.ldx.utils.RedisConstants.LOGIN_USER_KEY;

/**
 * @author ldx
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-05-27 09:04:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo getPages(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> list());
    }

    // 登录逻辑判断
    @Override
    public AjaxResult login(User user, HttpSession session) {
        if (user.getUsername() == null || user.getUsername() == "") return AjaxResult.fail("用户名不能为空");
        if (user.getPassword() == null || user.getPassword() == "") return AjaxResult.fail("密码不能为空");
        User u = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (u == null) return AjaxResult.fail("用户不存在,请前往注册页面");
        if (!u.getPassword().equals(user.getPassword())) return AjaxResult.fail("用户名或密码错误");
        //TODO 6.写入redis中
        // 6.1 随机生成token,作为登录令牌
        String token = UUID.randomUUID().toString(true);
        //TODO 6.2 将User转换成HashMap存储
        Map<String, Object> userMap = BeanUtil.beanToMap(u, new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true));
        //TODO 6.3存储
        stringRedisTemplate.opsForHash().putAll(LOGIN_USER_KEY + token, userMap);
        stringRedisTemplate.expire(LOGIN_USER_KEY + token, LOGIN_TOKEN_TTL, TimeUnit.SECONDS);
        // 7返回Token
        return AjaxResult.success("登录成功", token);
    }
}




