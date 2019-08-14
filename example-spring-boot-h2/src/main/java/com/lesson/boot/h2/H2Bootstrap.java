package com.lesson.boot.h2;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
@SpringBootApplication
public class H2Bootstrap{


    @Autowired
    private StudentMapper studentMapper;

    public static void main(String[] args) {
        SpringApplication.run(H2Bootstrap.class,args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onEvent(){
        LambdaQueryWrapper<Student> wrapper =  new QueryWrapper<Student>().lambda();
        IPage<Student> page =  new Page<>(2,20);
        page =  studentMapper.selectPage(page,wrapper);

       System.out.println(JSON.toJSONString(page.getRecords()));


    }


}
