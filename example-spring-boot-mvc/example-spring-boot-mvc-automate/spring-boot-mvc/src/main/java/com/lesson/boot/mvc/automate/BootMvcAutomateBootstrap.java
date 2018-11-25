package com.lesson.boot.mvc.automate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@SpringBootApplication(scanBasePackages = "com.lesson.boot.mvc.automate")
public class BootMvcAutomateBootstrap {

    public static void main(String[] args){


        SpringApplication.run(BootMvcAutomateBootstrap.class,args);

    }
}
