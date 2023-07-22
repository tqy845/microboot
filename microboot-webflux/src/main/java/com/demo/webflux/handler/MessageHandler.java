package com.demo.webflux.handler;

import com.demo.webflux.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class MessageHandler {   // 这是一个webflux的处理模块
    // 在WebFlux里如果要进行响应的话会区分单个响应（单一对象）或者多个响应（集合）
    public Flux<Message> list(Message message) {
        List<Message> messageList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            messageList.add(new Message("title - " + i, "text - " + i));
        }
        return Flux.fromIterable(messageList);  // 响应集合
    }

    public Flux<Map.Entry<String, Message>> map(Message message) {
        Map<String, Message> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("map - " + i, new Message("title - " + i, "text - " + i));
        }
        return Flux.fromIterable(map.entrySet());
    }

    public Mono<Message> echoMessage(Message message) {
        log.info("【{}】业务层接收数据:{}", Thread.currentThread().getName(), message);
        return Mono.create(messageMonoSink -> messageMonoSink.success(message));    // 实现数据响应
    }
}
