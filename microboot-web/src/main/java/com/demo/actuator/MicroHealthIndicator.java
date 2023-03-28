package com.demo.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class MicroHealthIndicator implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    // 现在是一个独立的Bean组件，就可以直接注入其他依赖
    @Override
    public Health health() { // 返回健康状态
        int errorCode = 100;
        // 触发返回的条件
        if (errorCode != 0) {
            return Health.down().withDetail("MicroServiceErrorCode", errorCode).withException(new Exception("服务故障!")).build();   // 不健康
        }
        return Health.up().build(); // 健康
    }
}
