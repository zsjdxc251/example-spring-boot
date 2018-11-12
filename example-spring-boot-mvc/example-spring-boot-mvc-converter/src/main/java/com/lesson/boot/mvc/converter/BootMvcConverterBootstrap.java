package com.lesson.boot.mvc.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@SpringBootApplication
public class BootMvcConverterBootstrap {

    public static void main(String[] args){

        ApplicationContext applicationContext = SpringApplication.run(BootMvcConverterBootstrap.class,args);
    }

    @Bean
    public CustomErrorViewResolver errorViewResolver(){
        return new CustomErrorViewResolver();
    }
}
