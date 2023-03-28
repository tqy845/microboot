package com.demo.action;

import com.demo.commond.validation.annotation.WrapResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jvm/*")
@WrapResponse
public class MemoryAction {

    @RequestMapping("memory")
    public Object memory() {
        // 获取Runtime对象实例
        Runtime runtime = Runtime.getRuntime();

        Map<String, Object> data = new HashMap<>();

        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        data.put("demo", httpServletRequest.getParameter("demo"));
        data.put("maxMemory", runtime.maxMemory());
        data.put("totalMemory", runtime.totalMemory());
        data.put("freeMemory", runtime.freeMemory());

//        throw new RuntimeException("错误");
        return data;
    }
}
