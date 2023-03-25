package com.demo.config;

import com.demo.vo.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Date;

@Configuration
public class MessageConfig {


    @Bean
    public Message getMessage() {
        Message message = new Message();
        message.setMsg("爱果");
        message.setPubdate(new Date());
        return message;
    }
}
