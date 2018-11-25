package com.lesson.boot.mvc.servlet.automate;

import com.lesson.boot.mvc.servlet.natives.servlet.AsyncServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;



/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
@SpringBootApplication
@ServletComponentScan({"com.lesson.boot.mvc.servlet.natives.servlet"})
public class BootMvcServletAutomateBootstrap {

    public static void main(String[] args){

        SpringApplication.run(BootMvcServletAutomateBootstrap.class,args);
    }


//    @Bean
//    public ServletRegistrationBean<HttpServlet> asyncServlet(){
//
//
//        return new ServletRegistrationBean<>(new AsyncServlet(),"/async1");
//    }
//
//
//    @Bean
//    public ServletContextInitializer servletContextInitializer(){
//
//        return servletContext -> {
//
//            servletContext.addServlet("async2",new AsyncServlet());
//
//        };
//    }
//
//
//    @Bean
//    public HttpServlet async21(){
//        return new AsyncServlet();
//    }
}
