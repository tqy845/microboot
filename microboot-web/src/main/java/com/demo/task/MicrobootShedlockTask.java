package com.demo.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component // 任务的处理类需要提供一个组件
@Slf4j
public class MicrobootShedlockTask {

//    @Scheduled(fixedDelay = 2000)   // 每两秒触发一次当前任务
//    public void runJobA() throws InterruptedException {
//        log.info("[RATE任务]{}" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
//        TimeUnit.SECONDS.sleep(5);  // 强制模拟5秒的延时
//    }

    // @SchedulerLock注解里面对于任务独占锁的时间有两个配置项：
    // lockAtLeastFor：成功执行定时任务的任务节点所能拥有的独占锁的最短时间
    // lockAtMostFor： 成功执行定时任务的任务节点所能拥有的独占锁的最长时间
    @Scheduled(cron = "*/2 * * * * ?") // 每秒触发一次cron任务
    @SchedulerLock(name = "microboot-task" , lockAtLeastFor = "5000") // 2秒后开启其他任务
    public void runJobB() throws InterruptedException {
        log.info("【Shedlock任务】{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        TimeUnit.SECONDS.sleep(5);
    }
}
