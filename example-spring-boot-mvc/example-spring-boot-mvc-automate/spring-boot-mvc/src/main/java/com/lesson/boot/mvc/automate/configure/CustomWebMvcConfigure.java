package com.lesson.boot.mvc.automate.configure;


import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.CodeSource;

/**
 * @author zhengshijun
 * @version created on 2018/11/22.
 */
@Configuration
public class CustomWebMvcConfigure {


	/**
	 * init
	 *

	 * @see  ServletWebServerFactoryAutoConfiguration
	 * @see  WebServerFactoryCustomizerBeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
	 *       {@code org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor#postProcessBeforeInitialization(org.springframework.boot.web.server.WebServerFactory)}
	 * <p>
	 * {@code ServletWebServerFactoryConfiguration.EmbeddedTomcat}
	 */
	@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> test() {


		return factory -> {


			CodeSource codeSource = getClass().getProtectionDomain().getCodeSource();


			File file = getCodeSourceArchive(codeSource);

			if (file.isDirectory()) {
				factory.setDocumentRoot(file);
			}
		};


	}


	//@Bean
	public WebServerFactoryCustomizer<TomcatServletWebServerFactory> demo() {


		System.out.println("11");

		return factory -> {

			factory.addContextCustomizers(context -> {


				File file = getCodeSourceArchive(getClass().getProtectionDomain().getCodeSource());
				System.out.println(file.getAbsolutePath());
				if (file.isDirectory()) {
					context.setDocBase(file.getAbsolutePath());
				} else if (file.isFile()) {
					context.setResources(new StandardRoot());
					WebResourceRoot webResourceRoot = context.getResources();


					try {
						webResourceRoot
								.createWebResourceSet(
										WebResourceRoot.ResourceSetType.RESOURCE_JAR,
										"/",
										new URL("file:/" + file.getAbsolutePath()),
										"/BOOT-INF/classes");
					} catch (MalformedURLException e) {
						e.printStackTrace();
					}

				}


//                String relativePath = "example-spring-boot-mvc/example-spring-boot-mvc-automate/spring-boot-mvc/target/classes";
//
//                File file = new File(relativePath);
//
//                context.setDocBase(file.getAbsolutePath());

				ClassPathResource classPathResource = new ClassPathResource("/templates/");

				try {
					System.out.println(classPathResource.getURL().getProtocol());
					System.out.println(classPathResource.getURL().getPath());

					System.out.println(getClass().getProtectionDomain().getCodeSource());


				} catch (IOException e) {
					e.printStackTrace();
				}

				URL url = this.getClass().getClassLoader().getResource("/templates/jsp/index.jsp");

				// System.out.println(url.getProtocol());

				//context.setDocBase("D:\\temp\\test.war");


//
//                try {
//                    webResourceRoot
//                            .createWebResourceSet(
//                                    WebResourceRoot.ResourceSetType.RESOURCE_JAR,
//                                    "/",
//                                    new URL("file:/D:\\workspace\\githome\\github\\example-spring-boot\\example-spring-boot-mvc\\example-spring-boot-mvc-automate\\spring-boot-mvc\\target\\spring-boot-mvc-1.0-SNAPSHOT.jar"),
//                                    "/BOOT-INF/classes");
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                }


			});


		};
	}

	File getCodeSourceArchive(CodeSource codeSource) {
		try {
			URL location = (codeSource != null) ? codeSource.getLocation() : null;
			if (location == null) {
				return null;
			}
			String path;
			URLConnection connection = location.openConnection();
			if (connection instanceof JarURLConnection) {
				path = ((JarURLConnection) connection).getJarFile().getName();
			} else {
				path = location.toURI().getPath();
			}
			int index = path.indexOf("!/");
			if (index != -1) {
				path = path.substring(0, index);
			}
			return new File(path);
		} catch (Exception ex) {
			return null;
		}
	}
}
