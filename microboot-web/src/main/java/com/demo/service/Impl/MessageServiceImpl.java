package com.demo.service.Impl;

import com.demo.service.IMessageService;
import com.demo.vo.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

    @Override
    public Object echo(Message msg) {
        return msg;
    }
}
