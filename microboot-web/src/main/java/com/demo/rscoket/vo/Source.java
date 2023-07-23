package com.demo.rscoket.vo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Data
@ConfigurationProperties("demo")
@Component
public class Source {
    
    private String mysql;
    private String redis;
    private List<String> messages;
    private Map<String, String> books;


}
