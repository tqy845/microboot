package com.demo.action;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RestController // 直接响应处理
@RequestMapping("/data/*")
public class ImageAction {
    @GetMapping(value = "image", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_PNG_VALUE})
    public BufferedImage createImageData() throws Exception {
        // 资源加载
        Resource imageResource = new ClassPathResource("/images/阿狸.jpg");
        // 实现文件加载
        return ImageIO.read(imageResource.getInputStream());
    }
}
