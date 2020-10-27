package com.lesson.boot.mvc.rest.config;

import com.lesson.boot.mvc.rest.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 *  扩展WebMvc 配置实现   {@link WebMvcConfigurer}
 *
 * @author zhengshijun
 * @version created on 2018/11/23.
 */
@Configuration
public class SimpleWebMvcConfigure implements WebMvcConfigurer {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer
                .favorPathExtension(true)
                .defaultContentType(MediaType.APPLICATION_JSON_UTF8);
    }

//    @Bean
//    public Filter filter(){
//        return new Filter() {
//            @Override
//            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//                throw new RuntimeException("demo");
//                //System.out.println(servletRequest);
//            }
//        };
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new PropertiesHttpMessageConverter());

    }
}
