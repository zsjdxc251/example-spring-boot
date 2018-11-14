package com.lesson.boot.mvc.resource.configure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

import java.util.List;

/**
 *
 * @see WebMvcAutoConfiguration
 *
 *        implements {@link WebMvcConfigurer} ： 不会覆盖{@link EnableAutoConfiguration}    关于{@link WebMvcAutoConfiguration}的配置
 *
 *        {@link EnableWebMvc} + implements {@link WebMvcConfigurer} ： 会覆盖{@link EnableAutoConfiguration}   关于{@link WebMvcAutoConfiguration}的配置
 *
 *        extends {@link WebMvcConfigurationSupport} ：会覆盖{@link EnableAutoConfiguration}   关于{@link WebMvcAutoConfiguration}的配置
 *
 *        extends {@link DelegatingWebMvcConfiguration} ：会覆盖{@link EnableAutoConfiguration}    关于{@link WebMvcAutoConfiguration}的配置
 *
 *
 * @author zhengshijun
 * @version created on 2018/11/13.
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/META-INF/resources/")
                // resourceChain(false) 的作用后面会讲解
                .resourceChain(false)
                //.addTransformer()
                // 添加 VersionResourceResolver，且指定版本号
                .addResolver(new VersionResourceResolver()
                        .addFixedVersionStrategy("1.0.0", "/js/lib/**"));


    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
