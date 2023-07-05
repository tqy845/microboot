package com.demo.config;

import com.demo.task.DynmaicCronExpression;
import com.demo.task.MicrobootShedlockTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

@Configuration
@Slf4j
public class DynmaicScheduleConfig implements SchedulingConfigurer { // 动态配置

    @Autowired // 额外注入
    private DynmaicCronExpression expression;// 动态表达式
    @Autowired
    private MicrobootShedlockTask task; // 定时任务处理类
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                // 要执行的任务
                ()->task.task(),
                triggerContext -> {
                    // 任务触发表达式
                    log.info("设置当前的cron表达式：{}",expression.getCron());
                    String cron = expression.getCron();
                    // 创建一个cron任务，设置下一次执行时间
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                });
    }
}
