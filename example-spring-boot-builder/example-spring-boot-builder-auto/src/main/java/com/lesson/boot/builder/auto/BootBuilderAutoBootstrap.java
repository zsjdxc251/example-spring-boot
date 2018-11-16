package com.lesson.boot.builder.auto;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author zhengshijun
 * @version created on 2018/11/16.
 */
@SpringBootApplication
public class BootBuilderAutoBootstrap {

    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(BootBuilderAutoBootstrap.class,args);

        System.out.println(StringUtils.join(applicationContext.getBeanDefinitionNames(),"\n"));
    }
}
