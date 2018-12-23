package com.lesson.spring.boot.properties;

import com.lesson.spring.boot.properties.model.SingledataProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBindException;


import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ResolvableType;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.function.Consumer;

import static org.springframework.boot.context.properties.ConfigurationPropertiesBindingPostProcessor.VALIDATOR_BEAN_NAME;

/**
 * @author zhengshijun
 * @version created on 2018/12/23.
 */
@Configuration
public class CustomConfigurationProperties implements InitializingBean, EnvironmentAware, ApplicationContextAware {


    private Binder binder;

    private ConfigurableEnvironment environment;

    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {

        SingledataProperties bean = new SingledataProperties();

        ResolvableType type = getBeanType(bean);
        this.binder = new Binder(getConfigurationPropertySources(),
                getPropertySourcesPlaceholdersResolver(), getConversionService(),
                getPropertyEditorInitializer());

        Annotation[] annotations = new Annotation[] {  };
        Bindable<?> target = Bindable.of(type).withExistingValue(bean)
                .withAnnotations(annotations);

        binder.bind("spring.data.item[0]", target, null);


    }

    private ResolvableType getBeanType(Object bean) {
//        Method factoryMethod = this.beanFactoryMetadata.findFactoryMethod(beanName);
//        if (factoryMethod != null) {
//            return ResolvableType.forMethodReturnType(factoryMethod);
//        }
        return ResolvableType.forClass(bean.getClass());
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = (ConfigurableEnvironment)environment;
    }

    private Iterable<ConfigurationPropertySource> getConfigurationPropertySources() {
        return ConfigurationPropertySources.from(this.environment.getPropertySources());
    }

    private PropertySourcesPlaceholdersResolver getPropertySourcesPlaceholdersResolver() {
        return new PropertySourcesPlaceholdersResolver(this.environment.getPropertySources());
    }

    private ConversionService getConversionService() {
        return null;
    }

    private Consumer<PropertyEditorRegistry> getPropertyEditorInitializer() {
        if (this.applicationContext instanceof ConfigurableApplicationContext) {
            return ((ConfigurableApplicationContext) this.applicationContext)
                    .getBeanFactory()::copyRegisteredEditorsTo;
        }
        return null;
    }


}
