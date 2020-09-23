package com.lesson.boot.sharding;

import com.lesson.boot.sharding.configure.properties.DataSourceProperties;
import com.lesson.boot.sharding.service.OrderService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhengshijun
 * @version created on 2020/7/29.
 * {@link SpringBootConfiguration}
 */
@SpringBootApplication
public class ShardingBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(ShardingBootstrap.class,args);

	}

	@Bean
	public ApplicationRunner runner(OrderService orderService){

		return args -> {

			orderService.select();

		};
	}
}
