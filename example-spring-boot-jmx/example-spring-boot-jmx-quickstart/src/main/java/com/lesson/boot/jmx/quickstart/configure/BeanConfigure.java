package com.lesson.boot.jmx.quickstart.configure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

/**
 * @author zhengshijun
 * @version created on 2019/3/11.
 */
@Slf4j
@Configuration
public class BeanConfigure {

	@Bean
	public RmiRegistryFactoryBean rmiRegistry() {
		final RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
		rmiRegistryFactoryBean.setPort(8896);
		rmiRegistryFactoryBean.setAlwaysCreate(true);

		return rmiRegistryFactoryBean;
	}


	@Bean
	@DependsOn("rmiRegistry")
	public ConnectorServerFactoryBean connectorServerFactoryBean() throws Exception {
		final ConnectorServerFactoryBean connectorServerFactoryBean = new ConnectorServerFactoryBean();
		connectorServerFactoryBean.setObjectName("connector:name=rmi");

		String serviceUrl = String.format("service:jmx:rmi://%s:%s/jndi/rmi://%s:%s/jmxrmi", "127.0.0.1", 8896, "127.0.0.1", 8896);
		connectorServerFactoryBean.setServiceUrl(serviceUrl);
		log.info("ConnectorServerFactoryBean create success !! url:{}", serviceUrl);
		return connectorServerFactoryBean;
	}


}
