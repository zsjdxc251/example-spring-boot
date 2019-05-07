package com.lesson.boot.docs.quickstart;

import com.lesson.boot.docs.quickstart.properties.AppSystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.annotation.DirtiesContext;

/**
 * {@link Runtime#addShutdownHook(java.lang.Thread)}
 * <p>
 * <p>
 * log
 * <p>
 * {@link AnsiOutput}
 * <p>
 * <p>
 * {@link Serializer} {@link Deserializer}
 * <p>
 * {@code org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter}
 * <p>
 * {@link Cacheable}
 * <p>
 * {@link AutoConfigureMockMvc} {@link AutoConfigureWebTestClient} {@link DirtiesContext} {@link JooqTest}
 * <p>
 * {@link GroovyTemplateAutoConfiguration}
 * <p>
 * {@link FlywayProperties}
 * <p>
 * {@link ManagementServerProperties}
 * <p>
 * {@link MailProperties}
 *
 * <a href='https://docs.spring.io/spring-boot/docs/2.0.7.RELEASE/reference/htmlsingle/#common-application-properties'/>
 *
 * @author zhengshijun
 * @version created on 2019/5/6.
 */

@EnableAutoConfiguration
@EnableConfigurationProperties({AppSystemProperties.class,MailProperties.class})
public class DocsQuickstartBootstrap {




	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(DocsQuickstartBootstrap.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext applicationContext = springApplication.run(args);

		AppSystemProperties appSystemProperties = applicationContext.getBean(AppSystemProperties.class);

		System.out.println(appSystemProperties.getAddress());


		JavaMailSender sender = applicationContext.getBean(JavaMailSender.class);


		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("zsjdxc251@126.com");
		message.setTo("568374678@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");

		sender.send(message);

		springApplication.setRegisterShutdownHook(false);


		applicationContext.registerShutdownHook();


		//SpringApplication.exit(applicationContext);

	}
}
