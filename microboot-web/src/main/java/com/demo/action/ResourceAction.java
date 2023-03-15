package com.demo.action;

import com.demo.vo.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/source/*")
public class ResourceAction {

    @Resource
    private Source source;

    @GetMapping("show")
    public Object showResourceData() {
        return this.source;
    }
}
