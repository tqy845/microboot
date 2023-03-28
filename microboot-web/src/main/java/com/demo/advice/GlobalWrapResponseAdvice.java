package com.demo.advice;

import com.demo.commond.validation.annotation.WrapResponse;
import com.demo.vo.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice(basePackages = {"com.demo.action"})
public class GlobalWrapResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean wrap = returnType.hasMethodAnnotation(WrapResponse.class);
        if (!wrap) {
            WrapResponse anno = returnType.getMethod() == null ? null : returnType.getMethod().getDeclaringClass().getAnnotation(WrapResponse.class);
            if (anno != null) {
                wrap = true;
            }
        }
        return wrap;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return ResponseResult.builder().code(200).message("success").data(body).build();
    }
}
