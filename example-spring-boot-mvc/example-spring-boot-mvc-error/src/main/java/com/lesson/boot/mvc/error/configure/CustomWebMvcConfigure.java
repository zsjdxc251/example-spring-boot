package com.lesson.boot.mvc.error.configure;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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



    public Filter filter(){
        return new Filter() {
            @Override
            public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

                throw new RuntimeException("demo");
                //System.out.println(servletRequest);
            }
        };
    }

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(filter());
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        filterRegistrationBean.setUrlPatterns(urlPatterns);
        filterRegistrationBean.setName("custom name");
        filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR);
        return filterRegistrationBean;
    }

//    @Bean
//    public ErrorAttributes errorAttributes(){
//        return new ErrorAttributes() {
//            @Override
//            public Throwable getError(WebRequest webRequest) {
//                return null;
//            }
//
//            @Override
//            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//                return null;
//            }
//        };
//    }
}
