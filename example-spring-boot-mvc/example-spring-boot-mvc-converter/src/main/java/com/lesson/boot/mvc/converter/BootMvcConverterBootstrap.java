package com.lesson.boot.mvc.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @link https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 *
 *
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@SpringBootApplication
public class BootMvcConverterBootstrap {

    public static void main(String[] args){

        ApplicationContext applicationContext =
                SpringApplication.run(BootMvcConverterBootstrap.class,args);

        System.out.println(applicationContext.getBeanDefinitionNames().length);
        System.out.println(StringUtils.join(applicationContext.getBeanDefinitionNames(),"\n"));


    }


}
