package com.demo;

import com.demo.service.IMessageService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)  // 使用Junit5的测试工具
@WebAppConfiguration // 启动Web运行环境
@SpringBootTest(classes = StartSpringBootApplication.class)
public class TestMessageService {
    @Autowired
    private IMessageService messageService;

    @BeforeAll
    public static void init() {
        System.out.println("测试开始...");
    }

    @AfterAll
    public static void after() {
        System.out.println("测试结束...");
    }

    @Test
    public void testEcho() {
//        String ret = this.messageService.echo("www.aigs.ltd");
//        String value = "【ECHO】www.aigs.ltd";
//        System.out.println("value = " + value);
//        Assertions.assertEquals(ret, value);
    }
}
