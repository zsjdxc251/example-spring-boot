package com.lesson.boot.mvc.rest.config;

import com.lesson.boot.mvc.rest.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(new PropertiesHttpMessageConverter());

    }
}
