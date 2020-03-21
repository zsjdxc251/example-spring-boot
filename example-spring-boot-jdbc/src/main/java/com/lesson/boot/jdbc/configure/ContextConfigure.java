package com.lesson.boot.jdbc.configure;

import com.lesson.boot.jdbc.support.lock.DistributedLockTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author zhengshijun
 * @version created on 2020/2/15.
 */
@Configuration
public class ContextConfigure {

	@Bean
	public DistributedLockTemplate lockTemplate(StringRedisTemplate redisTemplate){
		return new DistributedLockTemplate(redisTemplate);
	}
}
