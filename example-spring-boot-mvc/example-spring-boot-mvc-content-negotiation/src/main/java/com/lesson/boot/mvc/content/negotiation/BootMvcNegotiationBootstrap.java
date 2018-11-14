package com.lesson.boot.mvc.content.negotiation;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
@SpringBootApplication
public class BootMvcNegotiationBootstrap {

    public static void main(String[] args){
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(BootMvcNegotiationBootstrap.class,args);

        WebMvcProperties webMvcProperties = applicationContext.getBean(WebMvcProperties.class);








    }
}
