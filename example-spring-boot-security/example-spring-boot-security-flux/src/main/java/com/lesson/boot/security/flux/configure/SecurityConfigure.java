package com.lesson.boot.security.flux.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.PathPatternParserServerWebExchangeMatcher;
import reactor.core.publisher.Mono;

/**
 * @author zhengshijun
 * @version created on 2019/3/29.
 */
@Slf4j
@Configuration
public class SecurityConfigure {


	public SecurityConfigure() {

	}

	private PathPatternParserServerWebExchangeMatcher pathPatternParserServerWebExchangeMatcher
			= new PathPatternParserServerWebExchangeMatcher("/api/app/**");

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http = http.httpBasic().disable()
				.formLogin().disable()
				.csrf().disable()
				.logout().disable();

		http.authorizeExchange()
				.pathMatchers("/abc/**").permitAll()
				.pathMatchers("/app/**")
				.access((mono, context) -> {

					context.getExchange().getAttributes().put("1","2");

					//context.getExchange().getRequest().mutate().header("uid","123");


					return Mono.just(new AuthorizationDecision(true));



				})
				.and()
				.authorizeExchange().anyExchange().authenticated().and()
				.exceptionHandling().authenticationEntryPoint((exchange, e) -> {
			ServerHttpResponse response = exchange.getResponse();
			response.setStatusCode(HttpStatus.UNAUTHORIZED);
			DataBuffer dataBuffer = response.bufferFactory().wrap(HttpStatus.UNAUTHORIZED.getReasonPhrase().getBytes());
			response.writeWith(Mono.just(dataBuffer));

			return response.setComplete();
		});
		return http.build();
	}


}
