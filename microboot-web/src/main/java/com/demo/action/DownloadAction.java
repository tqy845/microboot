package com.demo.action;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/data/*")
public class DownloadAction {
    @GetMapping("download")
    public void createFileData(HttpServletResponse httpServletResponse) throws IOException {
        // 启用强制性下载
        httpServletResponse.setContentType("application/force-download");
        // 文件名
        httpServletResponse.setHeader("Content-Disposition", "attachment;filename=aigs.zip");
        Resource resource = new ClassPathResource("/videos/模拟作业.rar");
        // 通过IO流读取文件内容，随后一点点进行文件下载操作
        InputStream inputStream = resource.getInputStream();
        // 每次读取1024字节
        byte[] data = new byte[1024];
        // 每次读取的个数
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            httpServletResponse.getOutputStream().write(data, 0, len);
        }
    }
}
