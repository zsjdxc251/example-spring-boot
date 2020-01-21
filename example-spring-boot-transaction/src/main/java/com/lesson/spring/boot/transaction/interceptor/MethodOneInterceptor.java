package com.lesson.spring.boot.transaction.interceptor;

import com.lesson.spring.boot.transaction.module.MethodOne;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @version created on 2020/1/21.
 */
@Slf4j
@Aspect
@Component
@Order(1)
public class MethodOneInterceptor {

	@Around("@annotation(methodOne)")
	public Object execute(ProceedingJoinPoint point, MethodOne methodOne) throws Throwable {

		log.info(" method :{}",methodOne);

		Object object = point.proceed();

		log.info(" method :{}",methodOne);

		return object;

	}
}
