package com.lesson.spring.boot.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author zhengshijun
 * @version created on 2019/8/13.
 */
@SpringBootApplication
public class RedisBootstrap {

    RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RedisBootstrap.class,args);
    }
}
