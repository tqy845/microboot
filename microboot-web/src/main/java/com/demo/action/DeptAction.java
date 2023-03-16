package com.demo.action;

import com.demo.vo.Dept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping("/dept/*")
public class DeptAction {
    @Resource
    private Dept dept;

    @GetMapping("demo")
    public Object get() {
        System.out.println("触发...");
        return this.dept;
    }
}
