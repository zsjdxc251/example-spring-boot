package com.lesson.boot.security.basic.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 *  {@link HttpSecurity#httpBasic()} 通过用户名:密码 BASE64散列之后 携带到请求头 authorization:Basic cm9vdDoxMjM0NTY=
 *
 *  使用加密方式：请求 authorization:Basic cm9vdDoxMjM0NTY=
 * @author zhengshijun
 * @version created on 2018/12/30.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
