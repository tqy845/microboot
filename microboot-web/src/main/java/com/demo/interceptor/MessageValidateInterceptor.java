package com.demo.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class MessageValidateInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, Object> map = new HashMap<>();

        if (request.getParameter("msg") == null || "".equals(request.getParameter("msg")))
            map.put("msg", "msg参数内容为空...");
        if (request.getParameter("pubdate") == null || "".equals(request.getParameter("pubdate")))
            map.put("pubdate", "pubdate参数内容为空...");

        if (map.isEmpty()) return true;
        // Jackson组件
        ObjectMapper objectMapper = new ObjectMapper();
        String errorJsonData = objectMapper.writer().writeValueAsString(map); // 获取错误的数据
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print(errorJsonData);

        return false; // 不跳转到控制层
    }
}
