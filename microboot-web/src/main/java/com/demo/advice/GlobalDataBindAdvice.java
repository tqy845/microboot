package com.demo.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalDataBindAdvice {
    @ModelAttribute(name = "bindModel")
    public Object dataBind() {
        // 绑定一个Map集合
        Map<String, Object> ret = new HashMap<>();
        
        return ret;
    }
}
