package com.lesson.spring.boot.transaction;

import com.lesson.spring.boot.transaction.service.DoingService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zhengshijun
 * @version created on 2020/1/21.
 */
@SpringBootApplication
public class Bootstrap {

	public static void main(String[] args) {

		SpringApplication.run(Bootstrap.class);
	}

	@Bean
	ApplicationRunner runner(DoingService doingService) {

		return arguments -> {

			doingService.execute();

		};
	}
}
