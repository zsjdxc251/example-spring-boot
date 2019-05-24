package com.lesson.boot.security.flux.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/3/28.
 */
@Slf4j
@Component
public class AccessFilter implements WebFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

		Map<String,Object> attr = exchange.getAttributes();
		ServerHttpRequest.Builder builder = exchange.getRequest().mutate();

		if (!ObjectUtils.isEmpty(attr)){
			attr.forEach((key,value)->builder.header(key,String.valueOf(value)));
		}

		ServerWebExchange newExchange = exchange.mutate().request(builder.build()).build();

		return chain.filter(newExchange);
	}
}
