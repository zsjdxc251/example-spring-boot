package com.lesson.spring.boot.transaction.interceptor;

import com.lesson.spring.boot.transaction.module.MethodTwo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @version created on 2020/1/21.
 */
@Slf4j
@Aspect
@Component
@Order(-1)
public class MethodTwoInterceptor {

	@Around("@annotation(methodTwo)")
	public Object execute(ProceedingJoinPoint point, MethodTwo methodTwo) throws Throwable {
		log.info(" method :{}",methodTwo);

		Object object = point.proceed();

		log.info(" method :{}",methodTwo);

		return object;


	}

}
