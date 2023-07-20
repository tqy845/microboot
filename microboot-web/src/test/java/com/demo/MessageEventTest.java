package com.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)  // 使用Junit5的测试工具
@WebAppConfiguration // 启动Web运行环境
@SpringBootTest(classes = StartSpringBootApplication.class)
public class MessageEventTest {
//    @Autowired
//    private ApplicationEventPublisher publisher;

    @Test
    public void testEvent() {
        System.out.println("测试进行...");
//        this.publisher.publishEvent(
//                new YootkEvent(
//                        this,
//                        new Message("www.aigs.ltd","demo")
//                )
//        );
    }
}
