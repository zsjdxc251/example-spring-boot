package com.lesson.boot.mvc.automate.configure;


import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * @author zhengshijun
 * @version created on 2018/11/22.
 */
@Configuration
public class CustomWebMvcConfigure  {

    public CustomWebMvcConfigure(){

        System.out.println("");
    }



    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> demo(){


        System.out.println("11");

        return factory -> {

            factory.addContextCustomizers(context -> {

                String relativePath = "example-spring-boot-mvc/example-spring-boot-mvc-automate/spring-boot-mvc/target/classes";

                File file = new File(relativePath);

                context.setDocBase(file.getAbsolutePath());


            });


        };
    }
}
