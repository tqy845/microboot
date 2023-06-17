package com.demo.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration  // 配置类注解
//@EnableScheduling // 启动定时任务
// 分布式任务的调度如果锁被占据，那么其他节点是无法访问的
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S") // 30秒强制释放锁
public class ShedlockRedisConfig {
    @Value("${spring.profiles.active}")  // 采用默认环境
    private String env;// 当前应用环境
    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory){
        return new RedisLockProvider(connectionFactory, this.env);
    }
}
