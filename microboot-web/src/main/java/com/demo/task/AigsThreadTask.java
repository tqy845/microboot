package com.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class AigsThreadTask {
    @Async // 启用异步处理
    public void startTaskHandler(){
        log.info("【异步线程】开启，执行线程：{}", Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ignored) {
        }
        log.info("【异步线程】结束，执行线程：{}",Thread.currentThread().getName());
    }
}
