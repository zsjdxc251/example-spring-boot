package com.lesson.boot.jdbc.support.lock;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
public class DistributedLockTemplate {

    private final StringRedisTemplate redisTemplate;

    public DistributedLockTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    Lock getRedisLock(String name,long expire, TimeUnit unit) {

        return new DistributedLock(name,expire,unit,redisTemplate);
    }


}

