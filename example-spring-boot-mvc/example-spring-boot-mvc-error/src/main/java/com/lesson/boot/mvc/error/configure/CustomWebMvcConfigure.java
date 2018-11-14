package com.lesson.boot.mvc.error.configure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer ,ErrorPageRegistrar{

    private static final Logger log = LoggerFactory.getLogger(CustomWebMvcConfigure.class);


    /**
     *  自定义错误页面
     *
     * @param registry
     */
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/public/404.html"));
        registry.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST,"/public/400.html"));
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
