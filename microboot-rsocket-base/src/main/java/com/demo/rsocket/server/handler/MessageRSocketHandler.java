package com.demo.rsocket.server.handler;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.util.DefaultPayload;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class MessageRSocketHandler implements RSocket {
    // 一般来说这种无响应可以应用在日志记录模式上，例如：客户端发送一个日志是不需要等待响应的
    @Override
    public Mono<Void> fireAndForget(Payload payload) {  // payload 表示所有附加的信息
        String message = payload.getDataUtf8();
        log.info("【FireAndForget】接收请求数据：{}", message);
        return RSocket.super.fireAndForget(payload);
    }

    @Override
    public Mono<Payload> requestResponse(Payload payload) { // 传统模式，有请求就有响应
        String message = payload.getDataUtf8();
        log.info("【RequestResponse】接收请求数据：{}", message);
        return Mono.just(DefaultPayload.create("【ECHO】" + message));
    }

    @Override
    public Flux<Payload> requestStream(Payload payload) {   // 流数据
        String message = payload.getDataUtf8();
        log.info("【RequestStream】接收请求数据：{}", message);
        return Flux.fromStream(message.chars()  // 将接收到的字符串转换为int流数据
                .mapToObj(c -> Character.toUpperCase((char) c)) // 获取每一个字符编码并转换为大写
                .map(Object::toString)  // 利用toString将字符转换为String
                .map(DefaultPayload::create));  // 创建附加数据
    }

    @Override
    public Flux<Payload> requestChannel(Publisher<Payload> payloads) {

        return Flux.from(payloads)
                .map(Payload::getDataUtf8)
                .map(msg -> {
                    log.info("【RequestChannel】接收请求数据：{}", msg);
                    return msg; // 返回发送的内容
                })
                .map(DefaultPayload::create);
    }
}
