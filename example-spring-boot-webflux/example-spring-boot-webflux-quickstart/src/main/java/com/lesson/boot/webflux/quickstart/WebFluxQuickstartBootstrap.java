package com.lesson.boot.webflux.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.support.WebExchangeDataBinder;
import org.springframework.web.server.ServerWebExchange;

/**
 *
 *  {@code org.springframework.web.reactive.result.method.annotation.RequestParamMethodArgumentResolver#resolveNamedValue(java.lang.String, org.springframework.core.MethodParameter, org.springframework.web.server.ServerWebExchange)}
 *
 *
 *  {@code org.springframework.web.reactive.result.method.InvocableHandlerMethod#resolveArguments(org.springframework.web.server.ServerWebExchange, org.springframework.web.reactive.BindingContext, java.lang.Object...)}
 *
 *
 *
 *
 *
 *
 *
 *    GlobalFilter & WebFilter 处理流程
 *
 *    org.springframework.cloud.gateway.handler.FilteringWebHandler
 *
 * org.springframework.web.server.handler.FilteringWebHandler#handle
 *
 * org.springframework.web.server.WebHandler
 *
 * org.springframework.web.reactive.DispatcherHandler#handle
 *
 *
 * org.springframework.http.server.reactive.ReactorHttpHandlerAdapter#apply
 *
 *
 * org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.ServerManager#handle
 *
 *
 * org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.ServerManager#start
 *
 *
 *
 *
 *  {@link WebExchangeDataBinder}
 *  {@link ServerWebExchange#getFormData()}
 *
 * @author zhengshijun
 * @version created on 2019/3/27.
 */
@SpringBootApplication
public class WebFluxQuickstartBootstrap {

	public static void main(String[] args) {
		SpringApplication.run(WebFluxQuickstartBootstrap.class,args);
	}
}
