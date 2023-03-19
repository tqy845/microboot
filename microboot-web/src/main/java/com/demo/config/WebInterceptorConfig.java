package com.demo.config;

import com.demo.interceptor.DefaultHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebInterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) { // 追加拦截器
        registry.addInterceptor(getDefaultHandlerInterceptor()).addPathPatterns("/**"); // 配置拦截路径
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    public HandlerInterceptor getDefaultHandlerInterceptor() {
        return new DefaultHandlerInterceptor();
    }
}
