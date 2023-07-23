package com.demo.rscoket.action;

import com.demo.rscoket.server.service.MessageService;
import com.demo.rscoket.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller // 这里不能使用Rest
@Slf4j
public class MessageAction {
    @Autowired
    private MessageService messageService;

    @MessageMapping("message.echo")
    public Mono<Message> echoMessage(Mono<Message> message) {
        return message.doOnNext(msg -> this.messageService.echo(msg))
                .doOnNext(msg -> log.info("【消息接收】{}", message));
    }

    @MessageMapping("message.delete")
    public void deleteMessage(Mono<String> title) {
        title.doOnNext(msg -> log.info("【消息删除】{}", msg)).subscribe();  // 日志输出
    }

    @MessageMapping("message.list")
    public Flux<Message> listMessage() {
        return Flux.fromStream(this.messageService.list().stream());
    }

    @MessageMapping("message.get")
    public Flux<Message> getMessage(Flux<String> title) {
        return title.doOnNext(t -> log.info("【消息查询】{}", t))
                .map(titleInfo -> titleInfo.toLowerCase())
                .map(this.messageService::get)
                .delayElements(Duration.ofSeconds(1));
    }
}
