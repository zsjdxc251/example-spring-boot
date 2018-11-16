package com.lesson.boot.builder.auto.configure;

import com.lesson.boot.builder.auto.service.UserInfoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengshijun
 * @version created on 2018/11/16.
 */

@Configuration
@EnableMicroService("micro")
@ConditionalOnBean(UserInfoService.class)
public class CoreConfigure {
}
