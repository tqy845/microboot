package com.demo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/errors/*")
public class ErrorPageAction {
    // 没有发现请求路径

    @RequestMapping("error_404")
    public Object errorCode404() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        httpServletResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        // 即便是错误页，也是正常响应
        Map<String, Object> ret = new HashMap<>();
        ret.put("status", HttpServletResponse.SC_NOT_FOUND);
        ret.put("info", "无法找到该页面...");
        // 获取之前的来源
        ret.put("refresh", httpServletRequest.getHeader("Refresh"));
        ret.put("path", httpServletRequest.getRequestURI());
        return ret;
    }

    @RequestMapping("error_500")
    public Object errorCode500() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse httpServletResponse = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        // 即便是错误页，也是正常响应
        Map<String, Object> ret = new HashMap<>();
        ret.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ret.put("info", "服务器内部错误...");
        // 获取之前的来源
        ret.put("refresh", httpServletRequest.getHeader("Refresh"));
        ret.put("path", httpServletRequest.getRequestURI());
        return ret;
    }
}
