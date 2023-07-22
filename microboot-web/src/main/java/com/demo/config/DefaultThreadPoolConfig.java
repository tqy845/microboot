package com.demo.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class DefaultThreadPoolConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {    // 异步执行者
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);   // 线程池大小
        executor.setMaxPoolSize(24);    // 最大数量
        executor.setQueueCapacity(100); // 延迟队列
        executor.setThreadNamePrefix("aigs - ");    // 设置线程名称的前缀
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {   // 异常处理
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
