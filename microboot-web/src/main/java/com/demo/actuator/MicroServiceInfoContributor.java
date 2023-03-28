package com.demo.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

// 进行组件注册
@Component
public class MicroServiceInfoContributor implements InfoContributor {
    // 自定义属性构造器
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("company.name", "aigs-demo");
        builder.withDetail("company.url", "www.aigs.ltd");
    }
}
