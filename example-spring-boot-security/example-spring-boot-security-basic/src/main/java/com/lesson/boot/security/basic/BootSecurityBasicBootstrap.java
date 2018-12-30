package com.lesson.boot.security.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author zhengshijun
 * @version created on 2018/12/30.
 */
@SpringBootApplication
@EnableGlobalMethodSecurity
public class BootSecurityBasicBootstrap {

    public static void main(String[] args){

        SpringApplication.run(BootSecurityBasicBootstrap.class,args);


    }
}
