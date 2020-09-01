package com.xgxx.springboot.commponent;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: LoginHandlerInterceptor
 * @Description: TODO 拦截器 ,登录检查
 * @Author dongxin
 * @Date 2020/7/9 0009 上午 10:54
 * @Version: 1.0
 **/
public class LoginHandlerInterceptor implements HandlerInterceptor {

    //目标方法执行之前,判断session是否存在的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {//在请求处理之前进行调用（Controller方法调用之前）
        Object user = request.getSession().getAttribute("loginUser");
        if(user == null){
            //未登录
            request.setAttribute("msg","没有登录权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            //已登录
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {//请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {//在整个请求结束之后被调用

    }
}
