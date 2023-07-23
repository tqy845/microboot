import com.demo.rsocket.server.MessageServer;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.TcpClientTransport;
import io.rsocket.util.DefaultPayload;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMessageServer {
    private static RSocket rSocket;

    @BeforeAll
    public static void setUpClient() {
        MessageServer.start();  // 服务启动
        rSocket = RSocketConnector.connectWith(TcpClientTransport.create(6565)).block(); // 客户端连接
    }

    @Test
    public void testFireAndForget() { // 测试RSocket模式
        getRequestPayload().flatMap(payload -> rSocket.fireAndForget(payload))
                .blockLast(Duration.ofMinutes(1));
    }

    @Test
    public void testRequestAndResponse() { // 测试RSocket模式
        getRequestPayload().flatMap(payload -> rSocket.requestResponse(payload))
                .doOnNext(response -> System.out.println("【RSocket测试类】接收服务端响应数据：" + response.getDataUtf8()))
                .blockLast(Duration.ofMinutes(1));
    }

    @Test
    public void testRequestAndStream() { // 测试RSocket模式
        getRequestPayload().flatMap(payload -> rSocket.requestStream(payload))
                .doOnNext(response -> System.out.println("【RSocket测试类】接收服务端响应数据：" + response.getDataUtf8()))
                .blockLast(Duration.ofMinutes(1));
    }

    @Test
    public void testRequestAndChannel() { // 测试RSocket模式
        rSocket.requestChannel(getRequestPayload())
                .doOnNext(response -> System.out.println("【RSocket测试类】接收服务端响应数据：" + response.getDataUtf8()))
                .blockLast(Duration.ofMinutes(1));
    }

    private static Flux<Payload> getRequestPayload() { // 传递所有的附加数据内容
        return Flux.just("aigs.com", "springboot", "edu.aigs.ltd", "springcloud", "redis")
                .delayElements(Duration.ofSeconds(1))
                .map(DefaultPayload::create);
    }

    @AfterAll
    public static void testStopServer() {
        MessageServer.stop();
    }
}
