package com.demo.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@AutoConfiguration  // 配置Bean
public class DefaultLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 接收参数名称locale，而传递的locale参数一般是"zh_CN"
        String locale = request.getParameter("locale");
        if (!StringUtils.hasLength(locale))
            // 没有内容
            return Locale.getDefault();
        // 数据拆分
        String[] split = locale.split("_");
        // 手动实例Locale对象
        return new Locale(split[0], split[1]);
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
    }

    @Bean
    public LocaleResolver localeResolver() {
        // 定义转换处理的Bean
        return new DefaultLocaleResolver();
    }
}
