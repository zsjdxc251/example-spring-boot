package com.lesson.spring.boot.redis.distlock;

import lombok.Getter;

import java.lang.reflect.Method;

/**
 * @author zhengshijun
 * @version created on 2019/9/17.
 */
@Getter
class LockExpressionRootObject {


	private final Method method;

	private final Object[] args;

	private final Object target;

	private final Class<?> targetClass;


	LockExpressionRootObject(Method method, Object[] args, Object target, Class<?> targetClass) {
		this.method = method;
		this.target = target;
		this.targetClass = targetClass;
		this.args = args;
	}

}
