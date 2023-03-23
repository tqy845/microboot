package com.demo.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create/*")
public class CreateErrorAction {

    @RequestMapping("error")
    public Object createError() {
        return 10 / 0;
    }
}
