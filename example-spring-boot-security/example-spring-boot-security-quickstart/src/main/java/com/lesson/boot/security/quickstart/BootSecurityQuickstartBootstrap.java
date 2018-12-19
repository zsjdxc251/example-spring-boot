package com.lesson.boot.security.quickstart;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * @author zhengshijun
 * @version created on 2018/12/19.
 */
@SpringBootApplication
public class BootSecurityQuickstartBootstrap {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext
                = SpringApplication.run(BootSecurityQuickstartBootstrap.class, args);

        System.out.println(StringUtils.join(applicationContext.getBeanDefinitionNames(),"\n"));
        System.out.println(applicationContext.getBeanDefinitionNames().length);
    }
}
