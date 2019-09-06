package com.lesson.spring.boot.redis.configure;

import com.lesson.spring.boot.redis.distlock.RedisLockTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
@Configuration
public class RedisConfigure {

    @Bean
    public RedisLockTemplate redisLockTemplate(StringRedisTemplate redisTemplate){
        return new RedisLockTemplate(redisTemplate);
    }
}

