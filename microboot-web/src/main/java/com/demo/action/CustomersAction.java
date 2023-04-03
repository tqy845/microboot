package com.demo.action;

import com.demo.commond.validation.annotation.WrapResponse;
import com.demo.domain.Customers;
import com.demo.mapper.CustomersMapper;
import com.demo.service.ICustomersService;
import com.demo.service.Impl.ICustomersServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@WrapResponse
@RequestMapping("/customers")
public class CustomersAction {
    @Resource
    private ICustomersService iCustomersService;

    @PostMapping("/")
    public Object create(@RequestBody Customers customers) {
        System.out.println(customers.toString());
        iCustomersService.save(customers);
        Map<String, Object> map = new HashMap<>();
        map.put("data", customers.toString());
        map.put("status", "插入成功");
        return map;
    }

//    @DeleteMapping("/")
//    public Object del(@RequestBody List<Long> ids) {
//        iCustomersService.removeByIds(ids);
//        return "相关数据已删除成功";
//    }

    @DeleteMapping("/{id}")
    public Object del(@PathVariable Long id) {
        System.out.println("id = " + id);
        iCustomersService.removeById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "删除成功");
        return map;
    }


}
