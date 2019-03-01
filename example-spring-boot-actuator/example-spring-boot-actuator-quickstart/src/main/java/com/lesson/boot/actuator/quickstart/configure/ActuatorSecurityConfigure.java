package com.lesson.boot.actuator.quickstart.configure;

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author zhengshijun
 * @version created on 2019/3/1.
 */
@Configuration
public class ActuatorSecurityConfigure {

	private static final String[] AUTH_WHITELIST = {
			"/resources/**",
			"/webjars/**",
			"/authorize/**",
			"/favicon.ico",
	};


	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http){
		http.httpBasic().disable()
				.formLogin().disable()
				.csrf().disable()
				.logout().disable();


		http.authorizeExchange().matchers(EndpointRequest.toAnyEndpoint()).authenticated()
				.anyExchange().hasRole("ENDPOINT_ADMIN")
				.and()
				.httpBasic();
		http

				.authorizeExchange()
				.matchers(EndpointRequest.to("health", "info"))
				.permitAll()
				.and()
				.authorizeExchange()
				.pathMatchers(HttpMethod.OPTIONS)
				.permitAll()
				.and()
				.authorizeExchange()
				.matchers(EndpointRequest.toAnyEndpoint())
				.hasAuthority("2")
				.and()
				.authorizeExchange()
				.pathMatchers(AUTH_WHITELIST).permitAll()
				.anyExchange().authenticated();

		return http.build();
	}

}
