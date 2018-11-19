package com.lesson.boot.mvc.quickstart;

import com.lesson.boot.mvc.quickstart.configure.WebMvcConfigure;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhengshijun
 * @version created on 2018/11/17.
 */
public class BootMvcQuickstartBootstrap {

    public static void main(String[] args){

        

        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(WebMvcConfigure.class);





    }
}
