package com.lesson.boot.mvc.code;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.LazyInitializationBeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.DispatcherServlet;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zhengshijun
 * @version created on 2020/10/28.
 */
public class SampleCreateWebServerListener implements ApplicationListener<WebServerInitializedEvent> {
	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {

		ApplicationContext applicationContext = event.getApplicationContext();
		if (Objects.nonNull(applicationContext.getParent())){
			return;
		}
		ConfigurableWebServerApplicationContext managementContext =
				this.createManagementContext(event.getApplicationContext(),
						PropertyPlaceholderAutoConfiguration.class,ServletFactoryCustomizer.class, DispatcherServlet.class);
		if (isLazyInitialization(applicationContext)) {
			managementContext.addBeanFactoryPostProcessor(new LazyInitializationBeanFactoryPostProcessor());
		}
		managementContext.setServerNamespace("management-custom");
		managementContext.setId(applicationContext.getId() + ":management-custom");
		setClassLoaderIfPossible(managementContext,applicationContext);
		//ManagementContextAutoConfiguration.CloseManagementContextListener.addIfPossible(applicationContext, managementContext);
		managementContext.refresh();
	}

	protected boolean isLazyInitialization(ApplicationContext applicationContext) {
		AbstractApplicationContext context = (AbstractApplicationContext)applicationContext;
		List<BeanFactoryPostProcessor> postProcessors = context.getBeanFactoryPostProcessors();
		return postProcessors.stream().anyMatch(LazyInitializationBeanFactoryPostProcessor.class::isInstance);
	}

	private void setClassLoaderIfPossible(ConfigurableApplicationContext child,ApplicationContext applicationContext) {
		if (child instanceof DefaultResourceLoader) {
			((DefaultResourceLoader) child).setClassLoader(applicationContext.getClassLoader());
		}
	}

	public ConfigurableWebServerApplicationContext createManagementContext(ApplicationContext parent,
			Class<?>... configClasses) {
		AnnotationConfigServletWebServerApplicationContext child = new AnnotationConfigServletWebServerApplicationContext();
		child.setParent(parent);
		List<Class<?>> combinedClasses = new ArrayList<>(Arrays.asList(configClasses));
		combinedClasses.add(ServletWebServerFactoryAutoConfiguration.class);
		child.register(ClassUtils.toClassArray(combinedClasses));
		registerServletWebServerFactory(parent, child);
		return child;
	}

	private void registerServletWebServerFactory(ApplicationContext parent,
			AnnotationConfigServletWebServerApplicationContext childContext) {
		try {
			ConfigurableListableBeanFactory beanFactory = childContext.getBeanFactory();
			if (beanFactory instanceof BeanDefinitionRegistry) {
				BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
				registry.registerBeanDefinition("ServletWebServerFactory",
						new RootBeanDefinition(determineServletWebServerFactoryClass(parent)));
			}

		}
		catch (NoSuchBeanDefinitionException ex) {
			// Ignore and assume auto-configuration
		}
	}

	private Class<?> determineServletWebServerFactoryClass(ApplicationContext parent)
			throws NoSuchBeanDefinitionException {
		Class<?> factoryClass = parent.getBean(ServletWebServerFactory.class).getClass();
		if (cannotBeInstantiated(factoryClass)) {
			throw new FatalBeanException("ServletWebServerFactory implementation " + factoryClass.getName()
					+ " cannot be instantiated. To allow a separate management port to be used, a top-level class "
					+ "or static inner class should be used instead");
		}
		return factoryClass;
	}

	private boolean cannotBeInstantiated(Class<?> factoryClass) {
		return factoryClass.isLocalClass()
				|| (factoryClass.isMemberClass() && !Modifier.isStatic(factoryClass.getModifiers()))
				|| factoryClass.isAnonymousClass();
	}
}
