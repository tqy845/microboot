package com.demo.filter;

import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 表示所有目录
@WebFilter("/*")
public class MessageFilter extends HttpFilter { // 定义过滤器

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        // 是否为echo的处理路径
        if ("/message/echo".equals(req.getRequestURI())) {
            String str = req.getParameter("msg");
            if (StringUtils.hasLength(str)) {
                // 有数据
                System.out.println("【MessageFilter】Msg参数内容为：" + str);
            }
        }
        chain.doFilter(req, res);
    }
}
