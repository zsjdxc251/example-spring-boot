package com.lesson.boot.security.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.MatcherSecurityWebFilterChain;

/**
 *  filters
 *   {@link HttpSecurityBuilder#addFilter(javax.servlet.Filter)}\
 *
 *
 *
 *   {@link FilterComparator}
 *{@link UserDetailsService}
 *   {@link InMemoryUserDetailsManager}
 *
 *{@link SecurityFilterChain}
 *     {@link DefaultSecurityFilterChain}
 *
 * {@link AbstractSecurityInterceptor}
 *
 *
 * {@link WebSecurityConfigurerAdapter#init(org.springframework.security.config.annotation.web.builders.WebSecurity)}
 * @author zhengshijun
 * @version created on 2018/12/30.
 */
@SpringBootApplication
public class BootSecurityBasicBootstrap {

    public static void main(String[] args){

        SpringApplication.run(BootSecurityBasicBootstrap.class,args);


    }
}
