package com.lesson.boot.statemachine.zookeeper;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */
@SpringBootApplication
public class StateMachineZookeeperBootstrap {

	public static void main(String[] args) {


		SpringApplication.run(StateMachineZookeeperBootstrap.class, args);

	}

	@Bean
	public PromptProvider myPromptProvider() {
		return () -> new AttributedString("spring-shell:>", AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
	}


}
