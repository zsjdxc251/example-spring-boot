package com.lesson.boot.security.basic.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

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
	protected void configure(HttpSecurity http) throws Exception {
		/*http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		http.authorizeRequests()
				.antMatchers("/favicon.ico").anonymous()
				.anyRequest().authenticated();*/

		//http.csrf().requireCsrfProtectionMatcher(request -> true);
		http.authorizeRequests().antMatchers("/api/demo").permitAll()
				.anyRequest().authenticated()
//				.expressionHandler(new SecurityExpressionHandler<FilterInvocation>() {
//					@Override
//					public ExpressionParser getExpressionParser() {
//						return new SpelExpressionParser();
//					}
//
//					@Override
//					public EvaluationContext createEvaluationContext(Authentication authentication, FilterInvocation invocation) {
//						return new StandardEvaluationContext();
//					}
//				})
		;


	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}
