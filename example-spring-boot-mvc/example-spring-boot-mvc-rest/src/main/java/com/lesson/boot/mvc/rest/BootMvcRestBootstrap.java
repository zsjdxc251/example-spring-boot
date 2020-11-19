package com.lesson.boot.mvc.rest;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link org.apache.catalina.core.StandardHostValve#throwable(org.apache.catalina.connector.Request, org.apache.catalina.connector.Response, java.lang.Throwable)}
 *
 *
 *
 * javax.servlet.ServletContainerInitializer
 *      org.springframework.web.SpringServletContainerInitializer
 * 	     org.springframework.web.WebApplicationInitializer
 *
* 	    org.springframework.boot.web.embedded.tomcat.TomcatStarter
* 	     org.springframework.boot.web.servlet.ServletContextInitializer
* 		     org.springframework.boot.web.servlet.FilterRegistrationBean
* 			 org.springframework.boot.web.servlet.FilterRegistrationBean
* 			 org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean
 *
 * @author zhengshijun
 * @version created on 2018/11/23.
 */
@SuppressWarnings("JavadocReference")
@SpringBootApplication
public class BootMvcRestBootstrap {
	public static void main(String[] args) {


		SpringApplication.run(BootMvcRestBootstrap.class, args);
	}
}
