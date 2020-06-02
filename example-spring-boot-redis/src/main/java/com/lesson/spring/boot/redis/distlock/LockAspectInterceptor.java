package com.lesson.spring.boot.redis.distlock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Component
@Slf4j
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE + 100)
public class LockAspectInterceptor extends AbstractAspectSupport {

	private final RedisLockTemplate lockTemplate;

	public LockAspectInterceptor(RedisLockTemplate lockTemplate) {
		this.lockTemplate = lockTemplate;

	}

	/**
	 * 环绕
	 *
	 * @param point     参数
	 * @param mutexLock 注解
	 * @return 返回结果
	 */
	@Around("@annotation(mutexLock)")
	public Object execute(ProceedingJoinPoint point, MutexLock mutexLock) throws Throwable {


		MethodSignature methodSignature = ((MethodSignature) point.getSignature());
		Object object;
		Lock lock = null;
		boolean unlock = Boolean.TRUE;
		try {
			String key = format(new OperationMetadata(point, mutexLock.key()));
			log.info("lockKey :{}, targetMethod:{}", key, methodSignature.getName());
			lock = lockTemplate.getRedisLock(key, mutexLock.expire(), mutexLock.unit());
			if (mutexLock.isTry()) {
				if (!lock.tryLock(mutexLock.time(), mutexLock.unit())) {
					unlock = Boolean.FALSE;
					Class<?> clazz = methodSignature.getReturnType();
					log.info("proxy target method returnType :{}", clazz);
					return null;
				}
			} else {
				lock.lock();
			}
			object = point.proceed();
		} catch (Throwable e) {
			log.error(StringUtils.EMPTY, e);
			throw e;
		} finally {
			if (unlock && Objects.nonNull(lock)) {
				lock.unlock();
			}
		}
		return object;
	}

}
