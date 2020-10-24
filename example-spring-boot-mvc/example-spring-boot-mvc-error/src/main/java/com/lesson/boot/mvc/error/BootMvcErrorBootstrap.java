package com.lesson.boot.mvc.error;

import javafx.beans.property.ObjectProperty;
import org.apache.catalina.core.ApplicationFilterFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 *  {@code StandardHostValve#throwable(org.apache.catalina.connector.Request, org.apache.catalina.connector.Response, java.lang.Throwable)}
 * {@link BasicErrorController}
 * {@code org.apache.catalina.core.ApplicationDispatcher#invoke(javax.servlet.ServletRequest, javax.servlet.ServletResponse, org.apache.catalina.core.ApplicationDispatcher.State)}
 *
 *  {@link ApplicationFilterFactory#matchDispatcher(org.apache.tomcat.util.descriptor.web.FilterMap, javax.servlet.DispatcherType)}
 *
 *  {@link HttpEncodingAutoConfiguration}
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@SpringBootApplication
public class BootMvcErrorBootstrap {

    @Autowired
    private ObjectProvider<FilterRegistrationBean> objectProvider;

    public static void main(String[] args){

        ApplicationContext applicationContext = SpringApplication.run(BootMvcErrorBootstrap.class,args);

        BootMvcErrorBootstrap bootMvcErrorBootstrap =  applicationContext.getBean(BootMvcErrorBootstrap.class);
        System.out.println(bootMvcErrorBootstrap.objectProvider);



    }
    @Bean
    public CustomErrorViewResolver errorViewResolver(){
        return new CustomErrorViewResolver();
    }

}
