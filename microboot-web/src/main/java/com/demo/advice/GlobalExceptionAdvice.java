package com.demo.advice;

import com.demo.rscoket.vo.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice // SpringMVC所提供的注解
public class GlobalExceptionAdvice {
    // 如果是一个包含有完整业务需求的项目，可以在此写上一些自定义的业务异常
    // 实现所有的异常处理
    @ExceptionHandler
    @ResponseBody
    public Object exceptionHandler(Exception exception) {
        Map<String, Object> ret = new HashMap<>() {{
            put("info", exception.getMessage());
            put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // 获取异常类型
            put("exception", exception.getClass().getName());
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            // 获取异常路径
            put("path", httpServletRequest.getRequestURI());
        }};

        return ResponseResult.builder().code(ResponseResult.ERROR).message(ResponseResult.ERROR_INFO).data(ret).build();
    }
}
