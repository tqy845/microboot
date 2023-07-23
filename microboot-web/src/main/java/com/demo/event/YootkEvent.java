package com.demo.event;

import com.demo.rscoket.vo.Message;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Getter
@Slf4j
public class YootkEvent extends ApplicationEvent {
    private Message message;
    public YootkEvent(Object source, Message message) { // 产生事件之后，保存具体事件的类型数据
        super(source);

        // 事件类型的存储
        this.message = message;
    }

    public void fire(){ // 自定义方法
        log.info("message = {}" , this.message);
    }
}
