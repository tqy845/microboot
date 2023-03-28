package com.demo.action;

import com.demo.service.IMessageService;
import com.demo.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/message/*") // 添加父路径
@Validated
@Slf4j
public class MessageAction { // 控制层的实现类
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageAction.class); // 获取日志实例

    @Resource
    private IMessageService messageService;

    @RequestMapping("echo") // 子路径
    public String echo(@Valid Message message) { // 进行请求参数的接收以及请求内容的回应
        log.info("接收msg的请求参数，内容为：{}", message); // SLF4j可以直接使用占位符
        log.error("接收msg的请求参数，内容为：{}", message); // SLF4j可以直接使用占位符
        log.warn("接收msg的请求参数，内容为：{}", message); // SLF4j可以直接使用占位符
        log.trace("接收msg的请求参数，内容为：{}", message); // SLF4j可以直接使用占位符
        log.debug("接收msg的请求参数，内容为：{}", message); // SLF4j可以直接使用占位符
        return this.messageService.echo(message); // 直接进行Rest响应
    }

    @RequestMapping("get")
    public Object get(@NotNull(message = "id不能为空...") @Length(max = 5, min = 1) String id) {
        return "【ECHO】" + id;
    }
}
