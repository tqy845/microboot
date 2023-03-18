package com.demo.action;

import org.eclipse.jetty.server.ServletAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/object/*")
public class ObjectAction {
    @RequestMapping("first")
    public Object firstShow(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        Map<String, Object> result = new HashMap<>();

        result.put("【request】contextPath", httpServletRequest.getContextPath());
        result.put("【request】messageParam", httpServletRequest.getParameter("message"));
        result.put("【request】method", httpServletRequest.getMethod());
        result.put("【session】sessionId", httpServletRequest.getSession().getId());
        result.put("【application】virtualServerName", httpServletRequest.getServletContext().getVirtualServerName());
        result.put("【application】initParameter", httpServletRequest.getServletContext().getInitParameter("teacher"));
        return result;
    }

    @RequestMapping("second")
    public Object secondShow() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        HttpServletResponse httpServletResponse = servletRequestAttributes.getResponse();
        Map<String, Object> result = new HashMap<>();
        result.put("【request】contextPath", httpServletRequest.getContextPath());
        result.put("【request】messageParam", httpServletRequest.getParameter("message"));
        result.put("【request】method", httpServletRequest.getMethod());
        result.put("【session】sessionId", httpServletRequest.getSession().getId());
        result.put("【application】virtualServerName", httpServletRequest.getServletContext().getVirtualServerName());
        result.put("【application】initParameter", httpServletRequest.getServletContext().getInitParameter("teacher"));
        return result;
    }

}
