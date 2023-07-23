package com.demo.action;

import com.demo.rscoket.vo.Company;
import com.demo.rscoket.vo.Dept;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dept/*")
public class DeptAction {


    @RequestMapping("add")
    public Object add(@ModelAttribute("company") Company company, @ModelAttribute("dept") Dept dept) {
        Map<String, Object> map = new HashMap<>();
        map.put("dept", dept);
        map.put("company", company);
        return map;
    }
}
