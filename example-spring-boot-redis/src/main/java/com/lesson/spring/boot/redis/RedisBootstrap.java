package com.lesson.spring.boot.redis;

import com.lesson.spring.boot.redis.distlock.DistributedLock;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


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
    public ApplicationRunner applicationRunner(StringRedisTemplate redisTemplate){
        return args -> {


            new DistributedLock("123",redisTemplate).lock();

        };
    }
}
