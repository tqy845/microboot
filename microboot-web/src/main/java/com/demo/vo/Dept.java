package com.demo.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "source")
@Component
public class Dept {
    private Long deptno;
    private String dname;
    private Company company;    // 关联属性
    private List<Emp> emps;
}
