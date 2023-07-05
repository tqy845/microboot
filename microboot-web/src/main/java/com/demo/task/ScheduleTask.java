package com.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class ScheduleTask {

    @Scheduled(fixedDelay = 2000)   // 每两秒触发一次任务
    public void runJobA()  {
        log.info("【RATE任务】{}" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Scheduled(cron = "* * * * * ?")    // 每秒触发一次任务
    public void runJobB(){
        log.info("【CRON任务】{}" , new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }
}
