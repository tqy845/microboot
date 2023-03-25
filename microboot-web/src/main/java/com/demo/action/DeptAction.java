package com.demo.action;

import com.demo.vo.Company;
import com.demo.vo.Dept;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dept/*")
public class DeptAction {


    @RequestMapping("add")
    public Object add(Company company , Dept dept){
        Map<String , Object> map = new HashMap<>();
        map.put("dept" , dept);
        map.put("company" , company);
        return map;
    }
}
