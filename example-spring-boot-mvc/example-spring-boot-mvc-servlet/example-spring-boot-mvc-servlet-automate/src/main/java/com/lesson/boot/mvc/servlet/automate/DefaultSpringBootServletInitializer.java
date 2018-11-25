package com.lesson.boot.mvc.servlet.automate;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {



        builder.sources(BootMvcServletAutomateBootstrap.class);


        return builder;
    }
}
