package com.demo.action;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/i18n/*") // 添加父路径
public class I18nAction { // 控制层的实现类
    @Resource
    private MessageSource messageSource; // 消息资源

    @RequestMapping("base") // 子路径
    public Object showBase() { // 进行请求参数的接收以及请求内容的回应
        Map<String, String> map = new HashMap<>();
        map.put("message", this.messageSource.getMessage("aigs.message", null, Locale.getDefault()));
        map.put("url", this.messageSource.getMessage("aigs.url", null, Locale.getDefault()));
        return map;
    }

    @RequestMapping("locale") // 子路径
    public Object showLocale(Locale locale) { // 进行请求参数的接收以及请求内容的回应
        Map<String, String> map = new HashMap<>();
        map.put("message", this.messageSource.getMessage("aigs.message", null, locale));
        map.put("url", this.messageSource.getMessage("aigs.url", null, locale));
        return map;
    }
}
