package com.lesson.boot.mvc.servlet.natives.servlet.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
@Configuration
@ComponentScan("com.lesson.boot.mvc.servlet.natives")
@EnableWebMvc
public class CustomWebMvcConfigure implements WebMvcConfigurer {


}
