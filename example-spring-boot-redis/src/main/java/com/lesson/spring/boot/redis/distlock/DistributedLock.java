package com.lesson.spring.boot.redis.distlock;

import io.lettuce.core.RedisFuture;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/8/23.
 */
public class DistributedLock implements Lock {

    private String key;

    private StringRedisTemplate template;

    public DistributedLock(String key,StringRedisTemplate template){
        this.key = key;
        this.template = template;
    }

    @Override
    public void lock() {


        Boolean result = template.execute((RedisCallback<Boolean>) connection -> {
            String uuid = UUID.randomUUID().toString();

            return connection.set(key.getBytes(),uuid.getBytes(),Expiration.from(100000,TimeUnit.MILLISECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);



        });

        System.out.println(result);

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

