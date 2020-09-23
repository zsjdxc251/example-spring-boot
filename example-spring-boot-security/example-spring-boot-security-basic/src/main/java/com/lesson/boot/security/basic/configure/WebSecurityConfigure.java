package com.lesson.boot.security.basic.configure;

import com.lesson.boot.security.basic.SampleAuthenticationManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * {@link HttpSecurity#httpBasic()} 通过用户名:密码 BASE64散列之后 携带到请求头 authorization:Basic cm9vdDoxMjM0NTY=
 * <p>
 * 使用加密方式：请求 authorization:Basic cm9vdDoxMjM0NTY=
 *
 * @author zhengshijun
 * @version created on 2018/12/30.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return new SampleAuthenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		http.authorizeRequests()
				.antMatchers("/favicon.ico").anonymous()
				.anyRequest().authenticated();



	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
