package com.lesson.boot.mvc.encrypt.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/6/5.
 */
@RestControllerAdvice("com.lesson.boot.mvc.encrypt.controller")
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice<ResponseEntity<Map<String, String>>> {
	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}


	@Override
	public ResponseEntity<Map<String, String>>
	beforeBodyWrite(ResponseEntity<Map<String, String>> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		return null;
	}
}
