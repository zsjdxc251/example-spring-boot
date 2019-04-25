package com.lesson.boot.mvc.automate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author zhengshijun
 * @version created on 2019/4/25.
 */
@SpringBootApplication
public class BootJspAutomateBootstrap extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(BootJspAutomateBootstrap.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		return builder.sources(BootJspAutomateBootstrap.class);
	}
}
