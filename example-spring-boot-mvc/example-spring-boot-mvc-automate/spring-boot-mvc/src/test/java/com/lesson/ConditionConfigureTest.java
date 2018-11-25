package com.lesson;

import com.lesson.boot.mvc.automate.configure.CoreConfigure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StringUtils;

import java.util.stream.Stream;

/**
 * @author zhengshijun
 * @version created on 2018/11/22.
 */
public class ConditionConfigureTest {

    public static void main(String[] args){


        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(CoreConfigure.class);


        System.out.println("\n");
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);



    }
}
