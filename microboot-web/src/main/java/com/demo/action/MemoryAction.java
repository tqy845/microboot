package com.demo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/jvm/*")
public class MemoryAction {

    @RequestMapping("memory")
    public Object memory() {
        // 获取Runtime对象实例
        Runtime runtime = Runtime.getRuntime();

        Map<String, Object> data = new HashMap<>();

        data.put("maxMemory", runtime.maxMemory());
        data.put("totalMemory", runtime.totalMemory());
        data.put("freeMemory", runtime.freeMemory());

        return data;
    }
}
