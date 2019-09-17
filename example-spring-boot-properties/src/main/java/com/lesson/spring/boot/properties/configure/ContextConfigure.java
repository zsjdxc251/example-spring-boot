package com.lesson.spring.boot.properties.configure;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;

/**
 * @author zhengshijun
 * @version created on 2019/9/17.
 */
public class ContextConfigure implements EnvironmentAware {

	private PropertyResolver  propertyResolver;

	@Override
	public void setEnvironment(Environment environment) {
		this.propertyResolver = environment;

	}
}
