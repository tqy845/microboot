package com.demo.action;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/data/*")
public class GlobalDataAction {
    @RequestMapping("echo")
    public Object echo(String message, Model model) {
        Map<String, Object> map = (Map<String, Object>) model.asMap().get("bindModel");
        map.put("data", "ECHO：" + message);
        return map;
    }

    @RequestMapping("calc")
    public Object calc(int x, int y, Model model) {
        Map<String, Object> map = (Map<String, Object>) model.asMap().get("bindModel");
        map.put("data", "ECHO：" + (x / y));
        return map;
    }
}
