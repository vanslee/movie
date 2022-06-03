package com.ldx.interceptor;


import com.ldx.dto.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 判断用户线程里是否存在用户
        if (UserHolder.getUser() == null) {
            response.setStatus(401);
            return false ;
        }
        // 有用户则放行
        return true;

    }

}
