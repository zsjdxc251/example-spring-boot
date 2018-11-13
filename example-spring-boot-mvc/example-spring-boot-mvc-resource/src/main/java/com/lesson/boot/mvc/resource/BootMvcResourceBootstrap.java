package com.lesson.boot.mvc.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@SpringBootApplication
public class BootMvcResourceBootstrap {

    public static void main(String[] args){

        ApplicationContext applicationContext = SpringApplication.run(BootMvcResourceBootstrap.class,args);

        ResourceProperties properties =applicationContext.getBean(ResourceProperties.class);
    }


}
