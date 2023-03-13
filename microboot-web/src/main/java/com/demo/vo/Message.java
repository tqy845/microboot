package com.demo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
@Data
public class Message {
    @XmlElement
    private String msg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @XmlElement
    private Date pubdate;
}
