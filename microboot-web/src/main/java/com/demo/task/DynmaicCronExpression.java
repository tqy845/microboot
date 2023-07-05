package com.demo.task;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component // 是一个独立的组件
@Data   // 生成相关的类结构
public class DynmaicCronExpression {
    private String  cron = "*/2 * * * * ?"; // 定义cron表达式

}
