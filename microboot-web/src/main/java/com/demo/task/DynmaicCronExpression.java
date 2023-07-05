package com.demo.task;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DynmaicCronExpression { // 动态CRON表达式
    private String cron = "*/2 * * * * ?"; // 每2秒执行一次事务



}
