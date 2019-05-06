package com.lesson.boot.docs.quickstart;

import com.lesson.boot.docs.quickstart.properties.AppSystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.jooq.JooqTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.serializer.Deserializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.test.annotation.DirtiesContext;

/**
 * {@link Runtime#addShutdownHook(java.lang.Thread)}
 * <p>
 * <p>
 * log
 * <p>
 * {@link AnsiOutput}
 *
 *
 * {@link Serializer} {@link Deserializer}
 *
 * {@code org.springframework.boot.actuate.web.trace.servlet.HttpTraceFilter}
 *
 * {@link Cacheable}
 *
 * {@link AutoConfigureMockMvc} {@link AutoConfigureWebTestClient} {@link DirtiesContext} {@link JooqTest}
 *
 *  {@link GroovyTemplateAutoConfiguration}
 *
 *  {@link FlywayProperties}
 * @author zhengshijun
 * @version created on 2019/5/6.
 */

@EnableAutoConfiguration
@EnableConfigurationProperties(AppSystemProperties.class)
public class DocsQuickstartBootstrap {

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(DocsQuickstartBootstrap.class);
		ConfigurableApplicationContext applicationContext = springApplication.run(args);

		AppSystemProperties appSystemProperties = applicationContext.getBean(AppSystemProperties.class);

		System.out.println(appSystemProperties.getAddress());


		springApplication.setRegisterShutdownHook(false);


		applicationContext.registerShutdownHook();


		//SpringApplication.exit(applicationContext);

	}
}
