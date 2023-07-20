package com.demo.event.listener;

import com.demo.event.YootkEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YootkEventListener implements ApplicationListener<YootkEvent> {
    @Override
    public void onApplicationEvent(YootkEvent event) {  // 事件监听后
        log.info("事件处理：{}", event.getMessage());
        event.fire();// 触发自定义事件
    }
}
