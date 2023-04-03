package com.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class MDCInterceptor implements HandlerInterceptor { // 定义拦截器

    private final static String REQUEST_ID = "request_id";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String forward = request.getHeader("X-Forwarded-For");
        String clintIo = request.getRemoteAddr();
        String uuid = UUID.randomUUID().toString();

        log.info("MDC操作记录开始：requestId = {}", uuid); // 日志输出
        log.info("requestId = {} , client = {} , X-Forwarded-For = {}", uuid, clintIo, forward);

        MDC.put(REQUEST_ID, uuid); // 保存了MDC的数据

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 每次请求后进行MDC删除
        String uuid = MDC.get(REQUEST_ID);
        log.info("MDC操作记录结束，requestId = {}", uuid);
        MDC.remove(REQUEST_ID);
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
