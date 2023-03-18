package com.demo.config;

import com.demo.filter.DemoFilter;
import com.demo.filter.EduFilter;
import com.demo.filter.TestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class WebFilterConfig { // 定义Web过滤器

    @Bean
    public FilterRegistrationBean getDemoFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(this.getDemoFilter());
        filterRegistrationBean.setName("demoFilter");
        filterRegistrationBean.addUrlPatterns("/orders/*");
        // 设置过滤器的执行顺序
        filterRegistrationBean.setOrder(5);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getTestFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(this.getTestFilter());
        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.addUrlPatterns("/orders/*");
        // 设置过滤器的执行顺序
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean getEduFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(this.getEduFilter());
        filterRegistrationBean.setName("eduFilter");
        filterRegistrationBean.addUrlPatterns("/orders/*");
        // 设置过滤器的执行顺序
        filterRegistrationBean.setOrder(-100);
        return filterRegistrationBean;
    }

    @Bean
    public Filter getDemoFilter() {
        return new DemoFilter();    // 手工实例化Filter实例
    }

    @Bean
    public Filter getTestFilter() {
        return new TestFilter();    // 手工实例化Filter实例
    }

    @Bean
    public Filter getEduFilter() {
        return new EduFilter();    // 手工实例化Filter实例
    }
}
