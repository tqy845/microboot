package com.demo.action;

import com.demo.service.IMessageService;
import com.demo.vo.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/message/*") // 添加父路径
public class MessageAction { // 控制层的实现类
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageAction.class); // 获取日志对象

    @Resource
    private IMessageService messageService;

    @RequestMapping("echo") // 子路径
    public String echo(Message message) { // 进行请求参数的接收以及请求内容的回应
        LOGGER.info("接收msg的请求参数，内容为：{}", message); // 日志输出
        return this.messageService.echo(message); // 直接进行Rest响应
    }
}
