package com.lesson.boot.mvc.configure;


import com.lesson.boot.mvc.configure.handler.CustomHandlerMethodReturnValueHandler;
import com.lesson.boot.mvc.configure.interceptors.CustomAppInterceptor;
import com.lesson.boot.mvc.configure.interceptors.CustomWebRequestInterceptor;
import com.lesson.boot.mvc.configure.resolver.CustomHandlerExceptionResolver;
import com.lesson.boot.mvc.configure.resolver.CustomHandlerMethodArgumentResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.number.CurrencyStyleFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer ,ErrorPageRegistrar{

    private static final Logger log = LoggerFactory.getLogger(CustomWebMvcConfigure.class);


    /**
     *
     *  number=￥323  -->>  323.0
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {


        registry.addFormatter(new CurrencyStyleFormatter());

    }

    /**
     *
     *  后执行
     * @see WebMvcConfigurationSupport#getMessageConverters()
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        log.info("extendMessageConverters:{}",converters==null?0:converters.size());
    }

    /**
     *  先执行
     * @see WebMvcConfigurationSupport#getMessageConverters()
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("configureMessageConverters:{}",converters==null?0:converters.size());

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("/index.html");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new CustomAppInterceptor());


        registry.addWebRequestInterceptor(new CustomWebRequestInterceptor()).addPathPatterns("/index/**");

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

        handlers.add(new CustomHandlerMethodReturnValueHandler());

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

        resolvers.add(new CustomHandlerExceptionResolver());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        resolvers.add(new CustomHandlerMethodArgumentResolver());
    }



    /**
     *  自定义错误页面
     *
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {

    }


    /**
     *
     *  静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {



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
