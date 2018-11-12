package com.lesson.boot.mvc.converter.configure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer ,ErrorPageRegistrar{

    private static final Logger log = LoggerFactory.getLogger(CustomWebMvcConfigurer.class);


    /**
     *  自定义错误页面
     *
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        //registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/public/500.html"));




    }


    /**
     *
     *  静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCachePeriod(0);

    }


    /**
     *
     *  跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
