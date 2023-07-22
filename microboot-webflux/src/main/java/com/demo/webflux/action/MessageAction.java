package com.demo.webflux.action;

import com.demo.webflux.handler.MessageHandler;
import com.demo.webflux.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/message/*")
public class MessageAction {

    @Autowired
    private MessageHandler messageHandler;

    @RequestMapping("echo")
    public Object echo(Message message){
        log.info("接收用户参数：{}",message);
        return this.messageHandler.echoMessage(message);
    }

    @RequestMapping("list")
    public Object list(Message message){
        log.info("接收用户参数：{}",message);
        return this.messageHandler.list(message);
    }

    @RequestMapping("map")
    public Object map(Message message){
        log.info("接收用户参数：{}",message);
        return this.messageHandler.map(message);
    }
}
