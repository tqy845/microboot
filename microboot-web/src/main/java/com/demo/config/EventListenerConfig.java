package com.demo.config;

import com.demo.rscoket.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class EventListenerConfig {  // 事件监听配置类
//    @EventListener
//    public void handleAllEvent(Object event){
//        log.info("【handleAllEvent()】{}",event);
//    }

//    @EventListener
//    public void handleYootkEvent(YootkEvent event){   // 如果传入的参数为指定事件类，则只会监听该指定事件
//        log.info("【handleYootkEvent()】{}",event);
//    }

//    // 使用条件触发事件监听
//    @EventListener(condition = "#event.message.title == 'aigs'")
//    public void handleYootkEventByCondition(YootkEvent event){   // 如果传入的参数为指定事件类，则只会监听该指定事件
//        log.info("【handleYootkEventByCondition()】{}",event);
//    }

    public void handleYootkEventByContent(Message message){
        log.info("【handleYootkEventByContent()】{}", message);
    }
}
