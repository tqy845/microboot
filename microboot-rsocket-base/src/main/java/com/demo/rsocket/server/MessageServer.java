package com.demo.rsocket.server;

import com.demo.rsocket.server.acceptor.MessageRSocketAcceptor;
import io.rsocket.core.RSocketServer;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import reactor.core.Disposable;

public class MessageServer {    // 实现RSocket的状态操作控制
    private static Disposable disposable;   // 用于释放任务
    public static void start(){
        RSocketServer rSocketServer = RSocketServer.create();   // 创建RSocket的服务端
        rSocketServer.acceptor(new MessageRSocketAcceptor());   // 创建连接器
        rSocketServer.payloadDecoder(PayloadDecoder.ZERO_COPY); // 采用0拷贝技术的实现
        disposable = rSocketServer.bind(TcpServerTransport.create(6565)).subscribe();   // 开启订阅
    }
    public static void stop(){
        disposable.dispose();   // 释放
    }
}
