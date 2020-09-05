package com.lesson.spring.boot.redis;

import com.alibaba.fastjson.JSON;
import com.lesson.spring.boot.redis.distlock.DistributedLock;
import com.lesson.spring.boot.redis.distlock.RedisLockTemplate;
import com.lesson.spring.boot.redis.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.stream.IntStream;


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
    public ApplicationRunner runner1(StringRedisTemplate redisTemplate){


        return args -> {


            BoundSetOperations<String,String> operations =  redisTemplate.boundSetOps("test:123");
//            operations.add("123d");
//            operations.add("123b");
//            operations.add("123c");

            System.out.println(operations.add("123i"));
            System.out.println(operations.add("123b"));
//            System.out.println(operations.isMember("123d"));
//            System.out.println(operations.isMember("9999"));
            Set<String> stringSet = operations.members();
            System.out.println(JSON.toJSONString(stringSet));



        };
    }

}
