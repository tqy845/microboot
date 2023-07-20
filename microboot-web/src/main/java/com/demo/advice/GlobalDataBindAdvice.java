//package com.demo.advice;
//
//import com.demo.vo.Message;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//import java.util.Map;
//
//@ControllerAdvice
//public class GlobalDataBindAdvice {
//    @Resource
//    private Message message;
//
//    @ModelAttribute(name = "bindModel")
//    public Object dataBind() {
//        // 绑定一个Map集合
//        Map<String, Object> ret = new HashMap<>();
//        ret.put("msg", "【aigs】" + this.message.getMsg());
//        ret.put("pubdate", this.message.getPubdate());
//        return ret;
//    }
//}
