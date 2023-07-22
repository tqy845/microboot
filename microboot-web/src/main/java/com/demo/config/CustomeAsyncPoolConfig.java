package com.demo.config;

import ognl.IteratorElementsAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.async.TimeoutCallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class CustomeAsyncPoolConfig implements WebMvcConfigurer {   // 自定义的线程池配置

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {  // 异步配置
        configurer.setDefaultTimeout(10000);
        configurer.registerCallableInterceptors(this.getTimeoutInterceptor());
        configurer.setTaskExecutor(this.getAsyncThreadPoolExecutor());
        WebMvcConfigurer.super.configureAsyncSupport(configurer);
    }

    @Bean(name = "asyncPoolTaskExecutor")   // 避免和springboot原生的线程池冲突
    public ThreadPoolTaskExecutor getAsyncThreadPoolExecutor(){
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(20);   // 内核线程的个数（物理线程个数*2）
        taskExecutor.setMaxPoolSize(200);   // 工作线程池的大小
        taskExecutor.setQueueCapacity(25);  // 设置延迟队列大小，代表有25个用户可以等待线程完成后执行
        taskExecutor.setKeepAliveSeconds(200);  // 存活时间
        taskExecutor.setThreadNamePrefix("aigs - "); // 配置前缀，个性化的配置
        taskExecutor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()
        ); // 配置拒绝策略，线程池满了是满了还是怎么的
        taskExecutor.initialize();
        return taskExecutor;
    }

    @Bean
    public TimeoutCallableProcessingInterceptor getTimeoutInterceptor(){    // 超时拦截器
        return new TimeoutCallableProcessingInterceptor();
    }
}
