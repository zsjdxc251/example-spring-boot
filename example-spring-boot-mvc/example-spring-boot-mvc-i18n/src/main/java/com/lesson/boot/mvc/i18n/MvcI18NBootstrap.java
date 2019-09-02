package com.lesson.boot.mvc.i18n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.server.i18n.LocaleContextResolver;

/**
 *
 * web flux
 * {@link LocaleContextResolver}
 * @author zhengshijun
 * @version created on 2019/9/2.
 */
@SpringBootApplication
public class MvcI18NBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(MvcI18NBootstrap.class,args);
    }
}
