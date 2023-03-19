package com.demo.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DefaultHandlerInterceptor implements HandlerInterceptor { // 自定义监听器


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否为指定类型的实例
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            // 控制器实例
            System.err.println("【Action对象】" + handlerMethod.getBean());
            System.err.println("【Action类型】" + handlerMethod.getBeanType());
            System.err.println("【Action方法】" + handlerMethod.getMethod());
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
