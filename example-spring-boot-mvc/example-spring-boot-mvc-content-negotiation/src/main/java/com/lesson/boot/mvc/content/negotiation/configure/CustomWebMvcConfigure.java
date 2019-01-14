package com.lesson.boot.mvc.content.negotiation.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.XmlBeamHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhengshijun
 * @version created on 2018/11/22.
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {


    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        configurer
                //.favorParameter(true)
                .favorPathExtension(true).mediaType("xml", MediaType.APPLICATION_XML)
        .mediaType("html",MediaType.TEXT_HTML);


    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new XmlBeamHttpMessageConverter());
    }
}
