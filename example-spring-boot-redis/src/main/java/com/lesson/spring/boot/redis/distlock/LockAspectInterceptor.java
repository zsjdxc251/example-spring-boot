package com.lesson.spring.boot.redis.distlock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Slf4j
@Aspect
public class LockAspectInterceptor extends AbstractLockAspectSupport {

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
	public Object execute(ProceedingJoinPoint point, MutexLock mutexLock) {

		Object object;
		Lock lock = null;
		try {
			String key = generateKey(new OperationMetadata(point, mutexLock));
			lock = lockTemplate.getRedisLock(key, mutexLock.expire(), mutexLock.unit());
			if (mutexLock.isTry()) {
				if (!lock.tryLock(mutexLock.time(), mutexLock.unit())) {
					return null;
				}
			} else {
				lock.lock();
			}
			object = point.proceed();
		} catch (Throwable e) {
			log.error(StringUtils.EMPTY, e);
			return null;
		} finally {
			if (Objects.nonNull(lock)) {
				lock.unlock();
			}
		}
		return object;
	}

}
