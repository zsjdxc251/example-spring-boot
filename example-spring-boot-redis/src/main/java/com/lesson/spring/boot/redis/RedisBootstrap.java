package com.lesson.spring.boot.redis;

import com.lesson.spring.boot.redis.distlock.DistributedLock;
import com.lesson.spring.boot.redis.distlock.RedisLockTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;


/**
 * @author zhengshijun
 * @version created on 2019/8/13.
 */
@SpringBootApplication
public class RedisBootstrap {



    public static void main(String[] args) {
        SpringApplication.run(RedisBootstrap.class,args);
    }



    @Bean
    public ApplicationRunner applicationRunner(RedisLockTemplate redisLockTemplate){
        return args -> {



            System.out.println("开始执行..");
            Lock lock = redisLockTemplate.getLock("123");

            lock.lock();
            TimeUnit.SECONDS.sleep(3);
            System.out.println("解锁..");
            lock.unlock();

            System.out.println("执行完了..");

        };
    }
}
