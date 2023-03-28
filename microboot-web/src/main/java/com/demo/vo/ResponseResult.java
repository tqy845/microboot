package com.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {
    public static final Integer SUCCESS = 200;
    public static final String SUCCESS_INFO = "success";
    public static final Integer ERROR = -1;
    public static final String ERROR_INFO = "fail";

    private Integer code;
    private String message;
    private Object data;
}
