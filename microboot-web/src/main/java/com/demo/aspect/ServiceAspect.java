package com.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect // 实现切面处理类
public class ServiceAspect { // 实现Aop切面管理

    @Around("execution(* com.demo..service..*.*(..))")
    public Object aroundInvoke(ProceedingJoinPoint point) throws Throwable {
        System.out.println("【ServiceInvokeBefore】执行参数：" + Arrays.toString(point.getArgs()));
        // 调用真实业务主题
        Object obj = point.proceed();
        System.out.println("【ServiceInvokeAfter】返回结果：" + obj);
        return obj;
    }
}
