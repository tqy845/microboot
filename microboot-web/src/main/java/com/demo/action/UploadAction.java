package com.demo.action;

import com.demo.rscoket.vo.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/form/*")
public class UploadAction {

    @PostMapping("upload")
    public Object uploadHandler(Message message, MultipartFile file) {
        // 保存最终上传的结果
        Map<String, Object> ret = new HashMap<>();
        ret.put("message", message);
        ret.put("fileName", file.getName());
        ret.put("fileOriginalFilename", file.getOriginalFilename());
        ret.put("fileContentType", file.getContentType());
        ret.put("fileSize", file.getSize());
        return ret;
    }
}
