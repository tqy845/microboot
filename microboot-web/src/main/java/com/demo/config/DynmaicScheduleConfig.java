package com.demo.config;

import com.demo.task.MicrobootShedlockTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

@Configuration
@Slf4j
public class DynmaicScheduleConfig implements SchedulingConfigurer { // 动态配置

    @Autowired // 额外注入
    private DynmaicScheduleConfig expression;// 动态表达式
    @Autowired
    private MicrobootShedlockTask task; // 定时任务处理类
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask();
    }
}
