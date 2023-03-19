package com.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) { // 上下文初始化
        System.out.println("【WebServletContextListener】Servlet初始化" + sce.getServletContext().getServerInfo());
        System.out.println("【WebServletContextListener】Servlet初始化" + sce.getServletContext().getRealPath("/"));
        System.out.println("【WebServletContextListener】Servlet初始化" + sce.getServletContext().getVirtualServerName());
        ServletContextListener.super.contextInitialized(sce);
    }
}
