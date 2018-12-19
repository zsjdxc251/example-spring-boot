package com.lesson.boot.security.quickstart.configure;

import com.lesson.boot.security.quickstart.SampleUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhengshijun
 * @version created on 2018/12/19.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private SampleUserDetailsService sampleUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


//        http
//                .logout()
//                .logoutUrl("/index/logout")
//                .logoutSuccessUrl("/index/index")
//                .logoutSuccessHandler((request, response, authentication) -> {
//
//                })
//                .invalidateHttpSession(true)
//                .addLogoutHandler((request, response, authentication) -> {
//
//                })
//                .deleteCookies("*")
//                .and();



        http
                .authorizeRequests()
                .antMatchers( "/index/home","/index/login").permitAll()
                .anyRequest().authenticated()
                .and()

                .formLogin()

                .loginPage("/index/login")

                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {


        auth.userDetailsService(sampleUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
