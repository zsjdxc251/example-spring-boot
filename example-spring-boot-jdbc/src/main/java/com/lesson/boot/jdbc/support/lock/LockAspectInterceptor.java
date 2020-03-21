package com.lesson.boot.jdbc.support.lock;



import com.lesson.boot.jdbc.support.context.AbstractAspectSupport;
import com.lesson.boot.jdbc.support.context.OperationMetadata;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Slf4j
@Aspect
//@Order
@Order(Ordered.HIGHEST_PRECEDENCE+100)
@Component
public class LockAspectInterceptor extends AbstractAspectSupport {

	private final DistributedLockTemplate lockTemplate;

	public LockAspectInterceptor(DistributedLockTemplate lockTemplate) {
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

		Object object;
		Lock lock = null;
		boolean unlock = Boolean.TRUE;
		try {
			String key = format(new OperationMetadata(point, mutexLock.key()));
			log.info("lockKey :{}", key);
			lock = lockTemplate.getRedisLock(key, mutexLock.expire(), mutexLock.unit());
			if (mutexLock.isTry()) {
				if (!lock.tryLock(mutexLock.time(), mutexLock.unit())) {
					unlock = Boolean.FALSE;
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
