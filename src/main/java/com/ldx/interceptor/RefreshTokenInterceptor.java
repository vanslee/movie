package com.ldx.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;

import com.ldx.dto.UserDTO;
import com.ldx.dto.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import static com.ldx.utils.RedisConstants.LOGIN_TOKEN_TTL;
import static com.ldx.utils.RedisConstants.LOGIN_USER_KEY;


public class RefreshTokenInterceptor implements HandlerInterceptor {
    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO 1.获取请求头中的Token
        String token = request.getHeader("authorization");
        if(StrUtil.isBlank(token)){
            return true;
        }
        //TODO 2.基于Token获取redis用户
        Map<Object, Object> userMap = stringRedisTemplate.opsForHash().entries(LOGIN_USER_KEY + token);
        //TODO 3.判断用户是否存在
        if(userMap.isEmpty()){
            // 用户不存在,拦截,返回401状态码
            return true;
        }
        //TODO 3.存在,保存用户信息到ThreadLocal中
        UserDTO userDTO = BeanUtil.fillBeanWithMap(userMap,new UserDTO(),false);

        //TODO 4.保存用户信息到ThreadLocal中
        UserHolder.saveUser(userDTO);
        //TODO 5.刷新token有效期
        stringRedisTemplate.expire(LOGIN_USER_KEY + token,LOGIN_TOKEN_TTL, TimeUnit.SECONDS);
        //TODO 6.放行
        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
