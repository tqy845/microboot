package com.demo.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/async/*") // 添加父路径
@Slf4j
public class MessageAction { // 控制层的实现类

    @RequestMapping("callable") // 子路径
    public Object echo(String msg) {
        // 外部线程
        log.info("外部线程：{}",Thread.currentThread().getName());
        System.out.println("外部线程：" +  Thread.currentThread().getName());
        // 返回一个异步线程
        return (Callable<String>) () -> {
            log.info("内部线程：{}", Thread.currentThread().getName());
            System.out.println("内部线程：" +  Thread.currentThread().getName());
            return "【ECHO】" + msg;
        };
    }

}
