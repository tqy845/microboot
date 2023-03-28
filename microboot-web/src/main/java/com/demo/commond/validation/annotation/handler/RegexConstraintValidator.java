package com.demo.commond.validation.annotation.handler;

import com.demo.commond.validation.annotation.RegexValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegexConstraintValidator implements ConstraintValidator<RegexValidator, Object> { // 处理类
    // 保存正则表达式
    private String regexExpression;

    @Override
    public void initialize(RegexValidator constraintAnnotation) {
        // 通过注解配置的内容获取表达式信息
        this.regexExpression = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return false;
        // 正则匹配
        try {
            return value.toString().matches(this.regexExpression);
        } catch (Exception e) {
            throw new RuntimeException("正则表达式有误...");
        }
    }
}
