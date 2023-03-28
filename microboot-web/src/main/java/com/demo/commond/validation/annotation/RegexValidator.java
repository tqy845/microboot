package com.demo.commond.validation.annotation;

import com.demo.commond.validation.annotation.handler.RegexConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {RegexConstraintValidator.class})   // 正则处理类
public @interface RegexValidator { // 自定义正则注解
    // 所有的验证注解必须提供三个内容 message groups payload

    String message() default "{数据的正则验证错误...}";  // 错误信息

    Class<?>[] groups() default {}; // 验证分组

    Class<? extends Payload>[] payload() default {}; // 附加的元数据的信息

    String pattern(); // 自定义属性，接收要使用的正则表达式
}