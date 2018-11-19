package com.lesson.boot.mvc.automate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.TomcatServletWebServerFactoryCustomizer;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@SpringBootApplication
public class BootMvcAutomateBootstrap {

    public static void main(String[] args){


        SpringApplication.run(BootMvcAutomateBootstrap.class,args);

    }
}
