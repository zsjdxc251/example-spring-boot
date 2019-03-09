package com.lesson.boot.mvc.automate.war;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zhengshijun
 * @version created on 2019/3/9.
 */
public class BootMvcAutomateWarInitializer extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootMvcAutomateWarBootstrap.class);
    }
}
