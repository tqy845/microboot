package com.demo.action;

import cn.hutool.json.JSONUtil;
import com.demo.domain.Customers;
import com.demo.service.IStudentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentAction {

    @Autowired
    private IStudentService studentServiceImpl;

    @GetMapping("/save")
    public String save() {
        System.out.println("save() in action");
        studentServiceImpl.save();
        return "save done...";
    }
}
