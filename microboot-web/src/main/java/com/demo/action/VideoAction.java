package com.demo.action;

import com.demo.config.handler.VideoResourceHttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// RestController 使用直接响应的方式
@RestController
@RequestMapping("/data/*")
public class VideoAction {

    @Resource
    private VideoResourceHttpRequestHandler videoResourceHttpRequestHandler;

    @GetMapping("video")
    public void createVideoData(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        this.videoResourceHttpRequestHandler.handleRequest(httpServletRequest, httpServletResponse);
    }
}
