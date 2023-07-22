package com.demo.action;

import com.demo.task.AigsThreadTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@RestController // 直接基于Rest架构进行处理，省略了@ResponseBody注解
@RequestMapping("/async/*") // 添加父路径
@Slf4j
public class MessageAction { // 控制层的实现类
//    @Autowired
//    private ThreadPoolTaskExecutor taskExecutor;

//    @RequestMapping("runnable") // 子路径
//    public Object echo(String msg) {
//        // 外部线程
//        log.info("外部线程：{}", Thread.currentThread().getName());
//        System.out.println("外部线程：" + Thread.currentThread().getName());
//        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
//        DeferredResult<String> result = new DeferredResult<>(6000L);
//        result.onTimeout(() -> {
//            System.out.println("超时线程" + Thread.currentThread().getName());
//            System.out.println("【请求超时】" + request.getRequestURI());
//        });
//        result.onCompletion(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程完成" + Thread.currentThread().getName());
//            }
//        });
//
//        this.taskExecutor.execute(new Runnable() {
//            @Override
//            public void run() {
//                // 完成的处理线程
//                System.out.println("内部线程：" + Thread.currentThread().getName());
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                result.setResult("【ECHO】" + msg);
//            }
//        });
//        return result;
//    }


    @Autowired
    private AigsThreadTask task;
    @RequestMapping("task")
    public Object echo(String msg){
        log.info("外部线程：{}",Thread.currentThread().getName());
        this.task.startTaskHandler();
        return "【ECHO】" + msg;
    }
}
