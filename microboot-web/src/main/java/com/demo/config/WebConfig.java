package com.demo.config;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        // 1. 默认在Springboot里面提供的转换器为Jackson组件，所以需要移除
        for (int x = 0; x < converters.size(); x++) {  // 循环所有转换器
            if (converters.get(x) instanceof MappingJackson2HttpMessageConverter) {
                converters.remove(x);
            }
        }

        // 2. 注册fastjson转换器
        
    }
}
