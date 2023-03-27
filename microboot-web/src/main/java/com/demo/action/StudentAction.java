package com.demo.action;

import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentAction {

    @SneakyThrows
    @PostMapping("student")
    public Object addStudent() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        BufferedReader br = request.getReader();
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        br.close();

        Map<String, Object> ret = new HashMap<>() {{
            put("code", 200);
            put("data", JSONUtil.parse(sb));
            put("message", "成功");
        }};

        return ret;
    }
}
