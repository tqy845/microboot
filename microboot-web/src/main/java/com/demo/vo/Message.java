package com.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
public class Message {
    @Excel(name = "信息", orderNum = "0", width = 130)
    private String msg;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", orderNum = "1", width = 50)
    private Date pubdate;
}
