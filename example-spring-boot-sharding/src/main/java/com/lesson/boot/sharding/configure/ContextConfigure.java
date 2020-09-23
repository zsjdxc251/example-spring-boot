package com.lesson.boot.sharding.configure;

import com.lesson.boot.sharding.configure.properties.DataSourceProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhengshijun
 * @version created on 2020/8/7.
 */
@Configuration
@MapperScan("com.lesson.boot.sharding.mapper")
@EnableTransactionManagement
@EnableConfigurationProperties(DataSourceProperties.class)
public class ContextConfigure {
}
