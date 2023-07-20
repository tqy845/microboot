package com.demo;

import com.demo.StartSpringBootApplication;
import com.demo.action.MessageAction;
import com.demo.vo.Message;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.awt.*;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)  // 使用Junit5的测试工具
@WebAppConfiguration // 启动Web运行环境
@SpringBootTest(classes = StartSpringBootApplication.class)
public class TestMessageAction {
    @Resource
    private MessageAction messageAction;

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
//        Date current = new Date();
//        Message m = Message.builder().msg("this is a demo info.").pubdate(current).build();
//        String ret = this.messageAction.echo();
//        System.out.println("ret = " + ret);
    }
}
