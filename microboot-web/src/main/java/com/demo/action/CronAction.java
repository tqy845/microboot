package com.demo.action;

import com.demo.task.DynmaicCronExpression;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/cron/*")
public class CronAction {
    @Autowired
    private DynmaicCronExpression expression;

    @GetMapping("set")
    public Object setCron(String cron){
         log.info("动态修改Cron配置");
         this.expression.setCron(cron);
         return true;
    }


}
