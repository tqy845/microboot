package com.demo.advice;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalDataPrefixAdvice { // 全局数据预处理
    @InitBinder("company")
    public void company(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("company.");
    }

    @InitBinder("dept")
    public void dept(WebDataBinder webDataBinder) {
        webDataBinder.setFieldDefaultPrefix("dept.");
    }


}
