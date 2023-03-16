package com.demo.action;

import com.demo.vo.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dept/*")
public class DeptAction {
    @Resource
    private Dept dept;

    @RequestMapping("get")
    public Object get() {
        return this.dept;
    }
}
