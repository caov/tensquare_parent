package com.tensquare.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: tensquare_parent
 * @description: 定义拦截器
 * @author: cf
 * @create: 2019-06-17 14:25
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler){
        System.out.println("经过了拦截器");
        final String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer")){
            final  String token = authHeader.substring(7);
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null){
                if ("admin".equals(claims.get("roles"))){//如果是管理员
                    request.setAttribute("admin_claims",claims);
                }
                if ("user".equals(claims.get("roles"))){//如果是用户
                    request.setAttribute("user_claims",claims);
                }
            }
        }
        return true;
    }
}
