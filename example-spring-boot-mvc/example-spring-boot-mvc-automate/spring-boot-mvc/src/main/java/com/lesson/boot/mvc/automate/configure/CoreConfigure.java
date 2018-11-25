package com.lesson.boot.mvc.automate.configure;

import com.lesson.boot.mvc.automate.service.UserInfoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author zhengshijun
 * @version created on 2018/11/22.
 */
public class CoreConfigure {




    @Bean(name = "userInfoService2")
    public UserInfoService userInfoService(){
        System.out.println("22");
        return new UserInfoService();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserInfoService userInfoService1(){
        System.out.println("11");
        return new UserInfoService();
    }
}
