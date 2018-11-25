package com.lesson.boot.mvc.rest.bind.annotation;

import java.lang.annotation.*;

/**
 * @author zhengshijun
 * @version created on 2018/11/23.
 *
 *
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PropertiesBody {

    boolean required() default true;
}
