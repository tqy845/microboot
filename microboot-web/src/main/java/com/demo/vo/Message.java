package com.demo.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.demo.commond.validation.annotation.RegexValidator;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class Message {
    @NotBlank(message = "{message.msg.not-blank.error}")
    @Excel(name = "信息", orderNum = "0", width = 130)
    private String msg;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布日期", orderNum = "1", width = 50)
    @NotNull(message = "{message.pubdate.not-blank.error}")
    private Date pubdate;

    @Email
    @NotBlank(message = "{message.email.not-blank.error}")
    private String email;

    @Digits(integer = 1, fraction = 0)
    private Integer level;

    @NotBlank(message = "{message.flag.not-blank.error}")
    @RegexValidator(pattern = "[a-zA-Z]{1,5}-\\d{1,3}", message = "{message.flag.regex.error}") // 自定义的验证规则
    private String flag;
}
