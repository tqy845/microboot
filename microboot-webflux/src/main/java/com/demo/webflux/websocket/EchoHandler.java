package com.demo.webflux.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class EchoHandler implements WebSocketHandler {

    @Override
    public List<String> getSubProtocols() {
        return WebSocketHandler.super.getSubProtocols();
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        log.info("Websocket客户端握手信息:{}" ,session.getHandshakeInfo().getUri());
        return session.send(session.receive().map(msg->session.textMessage("【ECHO】" + msg.getPayloadAsText())));
    }
}
