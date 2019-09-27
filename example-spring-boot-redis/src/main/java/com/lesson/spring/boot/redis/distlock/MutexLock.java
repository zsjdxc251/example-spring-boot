package com.lesson.spring.boot.redis.distlock;

import org.apache.commons.lang3.StringUtils;

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

    String key() default StringUtils.EMPTY;

    /**
     * 是否尝试
     *
     * @return bool
     */
    boolean isTry() default true;

    /**
     * 失效时间
     *
     * @return 时间
     */
    long expire() default 1000;

    /**
     * 等待时间
     *
     * @return 时间
     */
    long time() default 1000;

    /**
     * 单位 默认为毫秒
     *
     * @return 单位
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;


}

