package com.demo.config;

import com.demo.vo.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Bean
    public Message getMessage() {
        Message message = new Message();
        message.setMsg("[aigs]" + this.message.getMsg());
        message.setPubdate(this.message.getPubdate());
        return message;
    }
}
