package com.hzxy.language.web.interceptor;

import com.hzxy.language.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
        * 权限拦截器
        * <p>Title: PermissionInterceptor</p>
        * <p>Description: </p>
        *
        * @author Lusifer
        * @version 1.0.0
        * @date 2018/6/12 11:53
        */
public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // 以 login 结尾的请求
        if (modelAndView != null && modelAndView.getViewName() != null && modelAndView.getViewName().endsWith("/user/login")) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user != null) {
                httpServletResponse.sendRedirect("/user/main");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}