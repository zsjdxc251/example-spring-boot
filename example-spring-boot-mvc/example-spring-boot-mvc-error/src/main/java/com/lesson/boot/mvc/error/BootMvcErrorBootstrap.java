package com.lesson.boot.mvc.error;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@SpringBootApplication
public class BootMvcErrorBootstrap {

    public static void main(String[] args){

        ApplicationContext applicationContext = SpringApplication.run(BootMvcErrorBootstrap.class,args);
    }
    @Bean
    public CustomErrorViewResolver errorViewResolver(){
        return new CustomErrorViewResolver();
    }

}
