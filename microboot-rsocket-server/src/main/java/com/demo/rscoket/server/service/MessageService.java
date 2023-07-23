package com.demo.rscoket.server.service;


import com.demo.rscoket.vo.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    public List<Message> list() {
        return List.of(
                new Message("aigs - 1", "content - 1"),
                new Message("aigs - 2", "content - 2"),
                new Message("aigs - 3", "content - 3"),
                new Message("aigs - 4", "content - 4")
        );
    }

    public Message get(String title) {
        return new Message(title, "content - 1");
    }

    public Message echo(Message message) {
        message.setTitle("【ECHO】" + message.getTitle());
        message.setContent("【ECHO】" + message.getContent());
        return message;
    }
}
