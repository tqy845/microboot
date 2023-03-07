package com.demo.service.Impl;

import com.demo.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Override
    public String echo(String msg) {
        return "【ECHO】" + msg;
    }
}
