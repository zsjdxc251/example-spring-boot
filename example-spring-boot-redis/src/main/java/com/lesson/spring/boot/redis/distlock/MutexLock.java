package com.lesson.spring.boot.redis.distlock;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengshijun
 * @version created on 2019/9/7.
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MutexLock {

    boolean isTry() default true;

    long expire() default 0;

    TimeUnit unit() default TimeUnit.SECONDS;


}

