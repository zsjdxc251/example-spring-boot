package com.lesson.boot.listener.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2018/11/17.
 */
@SpringBootApplication
@Slf4j
public class BootListenerQuickstartBootstrap {

    public static void main(String[] args){
//        MDC.put("X-B3-TraceId","123");
//        MDC.put("traceId","123");
        SpringApplication.run(BootListenerQuickstartBootstrap.class,args);
//
//        log.info("启动完成");


    }
}
