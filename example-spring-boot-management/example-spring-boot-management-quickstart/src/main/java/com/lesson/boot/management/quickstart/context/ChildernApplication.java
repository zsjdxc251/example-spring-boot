package com.lesson.boot.management.quickstart.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.DefaultResourceLoader;

/**
 * @author zhengshijun
 * @version created on 2019/7/5.
 */

@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
public class ChildernApplication implements SmartInitializingSingleton, ApplicationContextAware {

	private ApplicationContext parent;






	private void setClassLoaderIfPossible(ConfigurableApplicationContext child) {
		if (child instanceof DefaultResourceLoader) {
			((DefaultResourceLoader) child)
					.setClassLoader(this.parent.getClassLoader());
		}
	}

	@Override
	public void afterSingletonsInstantiated() {
		AnnotationConfigServletWebServerApplicationContext managementContext = new AnnotationConfigServletWebServerApplicationContext();
		managementContext.setParent(parent);

		managementContext.setServerNamespace("management");
		managementContext.setId(parent.getId() + ":management");
		setClassLoaderIfPossible(managementContext);

		managementContext.refresh();

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.parent = applicationContext;
	}
}
