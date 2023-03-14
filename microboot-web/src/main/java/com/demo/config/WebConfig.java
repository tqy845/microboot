package com.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @ExceptionHandler
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
        // 实现图像转换
        converters.add(new BufferedImageHttpMessageConverter());

        // 1. 默认在Springboot里面提供的转换器为Jackson组件，所以需要移除
        for (int x = 0; x < converters.size(); x++) {  // 循环所有转换器
            if (converters.get(x) instanceof MappingJackson2HttpMessageConverter) {
                converters.remove(x);
            }
        }
        // 2. 实例化fastjson转换器
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();

        // 3. 配置fastjson转换器
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,        // 允许Map的内容为空
                SerializerFeature.WriteNullListAsEmpty,     // List集合为null则使用[]代替
                SerializerFeature.WriteNullStringAsEmpty,   // String内容为空时使用字符串代替
                SerializerFeature.WriteDateUseDateFormat,   // 日期格式化输出
                SerializerFeature.WriteNullNumberAsZero,    // 数字为空使用0表示i
                SerializerFeature.DisableCircularReferenceDetect   // 禁用循环引用
        );
        fastJsonHttpMessageConverter.setFastJsonConfig(config);

        // 4. 配置响应头
        List<MediaType> fastjsonMediaType = new ArrayList<>();// 定义所有响应类型
        fastjsonMediaType.add(MediaType.APPLICATION_JSON);  // 使用JSON类型进行响应
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastjsonMediaType);

        // 5. 在转换器列表之中添加当前配置完成的fastjson转换组件
        converters.add(fastJsonHttpMessageConverter);
    }
}
