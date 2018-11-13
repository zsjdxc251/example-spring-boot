package com.lesson.boot.mvc.resource.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

/**
 * @author zhengshijun
 * @version created on 2018/11/13.
 */
@Configuration
public class CustomWebMvcConfigure implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //registry.addResourceHandler("/static/**").addResourceLocations("classpath:/META-INF/resources/");
//                // resourceChain(false) 的作用后面会讲解
//                .resourceChain(false)
//                // 添加 VersionResourceResolver，且指定版本号
//                .addResolver(new VersionResourceResolver()
//                        .addFixedVersionStrategy("1.0.0", "/js/lib/**"));

    }
}
