package com.ljk.bit.interceptors;

import com.ljk.bit.entity.LoginInfo;
import com.ljk.bit.util.JWT;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TokenInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        if(uri.indexOf("login") >= 0 || uri.indexOf("index.jsp") >= 0 ||
                uri.indexOf("register") >=0 || uri.indexOf("/resources") >= 0){
            return true;
        }
        String token = httpServletRequest.getParameter("token");
        if(token == null){
            String url = httpServletRequest.getServletPath();
            httpServletRequest.getRequestDispatcher( "/index.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        LoginInfo loginInfo = JWT.unsign(token,LoginInfo.class);
        if(loginInfo == null){
            System.out.println("token 过期 重新登录");
            httpServletRequest.getRequestDispatcher( "/index.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
