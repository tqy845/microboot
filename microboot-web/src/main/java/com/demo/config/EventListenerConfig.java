package com.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class EventListenerConfig {  // 事件监听配置类
    @EventListener
    public void handleAllEvent(Object event){
        log.info("【handleAllEvent()】{}",event);
    }
}
