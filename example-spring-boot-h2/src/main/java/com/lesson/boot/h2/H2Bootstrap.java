package com.lesson.boot.h2;

import com.alibaba.fastjson.JSON;
import com.lesson.boot.h2.mapper.StudentMapper;
import com.lesson.boot.h2.model.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.h2.H2ConsoleAutoConfiguration;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 *
 *  {@link H2ConsoleAutoConfiguration}
 * @author zhengshijun
 * @version created on 2019/8/13.
 */
@Slf4j
@MapperScan("com.lesson.boot.h2.mapper")
@SpringBootApplication
public class H2Bootstrap{


    @Autowired
    private StudentMapper studentMapper;

    public static void main(String[] args) {
        SpringApplication.run(H2Bootstrap.class,args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onEvent(){

       List<Student> students =  studentMapper.selectList(null);

       System.out.println(JSON.toJSONString(students));


    }


}
