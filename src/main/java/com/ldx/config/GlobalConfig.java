package com.ldx.config;

import com.ldx.interceptor.JwtInterceptor;
import com.ldx.interceptor.LoginInterceptor;
import com.ldx.interceptor.RefreshTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JwtInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    // 刷新token拦截器
//        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate)).order(0);
    // 登录拦截器 默认全部拦截
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**") //拦截所有请求
            // 以下添加不拦截路径
            .excludePathPatterns("/user/login","/user/register").order(1);
}
}
