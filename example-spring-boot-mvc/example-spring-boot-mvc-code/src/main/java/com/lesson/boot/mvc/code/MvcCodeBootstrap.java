package com.lesson.boot.mvc.code;

import org.apache.catalina.core.StandardContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * {@link StandardContext}
 * {@code org.springframework.boot.web.embedded.tomcat.TomcatEmbeddedContext}
 * <p>
 * <p>
 * {@code org.springframework.boot.web.servlet.context.WebServerStartStopLifecycle#start()}
 * {@code ManagementContextAutoConfiguration.DifferentManagementContextConfiguration}
 * {@link ManagementServerProperties}
 *
 * @author zhengshijun
 * @version created on 2020/10/28.
 */
@SpringBootApplication
public class MvcCodeBootstrap {


	public static void main(String[] args) {

		//SpringApplication.run(MvcCodeBootstrap.class,args);
		SpringApplication application = new SpringApplication(MvcCodeBootstrap.class);
		application.addListeners(new SampleCreateWebServerListener());
		application.setLogStartupInfo(true);

		application.run(args);


	}
}
