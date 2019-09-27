package com.lesson.spring.boot.redis.distlock;

import com.google.common.collect.ImmutableList;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.types.Expiration;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zhengshijun
 * @version created on 2019/8/23.
 */
public class DistributedLock implements Lock {

    private static final RedisScript<Long> UNLOCK_SCRIPT = new DefaultRedisScript<>(LuaScriptRepository.UNLOCK_LUA_SCRIPT, Long.class);


    private String key;

    private StringRedisTemplate template;

    private String value;

    private final long expire;

    private final TimeUnit unit;

    private volatile boolean interrupted = false;


    public DistributedLock(String key, long expire, TimeUnit unit,StringRedisTemplate template) {
        this.key = key;this.expire = expire;
        this.unit = unit;
        this.template = template;
        this.value = UUID.randomUUID().toString();
    }

    @Override
    public void lock() {

        while (!interrupted && !tryLock()) {
            try {
                TimeUnit.MICROSECONDS.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        interrupted = Boolean.TRUE;
    }

    @Override
    public boolean tryLock() {

        Boolean result = template.execute(this::setNXPX);
        return result == null ? Boolean.FALSE : result;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        long currentTime = System.currentTimeMillis();
        long waitTime = unit.toMillis(time);
        while (!tryLock()) {
            if (System.currentTimeMillis() > (currentTime + waitTime)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public void unlock() {


        Long aLong = template.execute(UNLOCK_SCRIPT, ImmutableList.of(key), value);
        if (!Objects.equals(aLong, 1L)){
            throw new IllegalArgumentException();
        }
        System.out.println(aLong);
    }

    @Override
    public Condition newCondition() {
        return null;
    }


    private Boolean setNXPX(RedisConnection connection) {

        return connection.set(key.getBytes(), value.getBytes(), Expiration.from(100000, TimeUnit.MILLISECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);
    }
}

