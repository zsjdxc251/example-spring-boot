package com.lesson.spring.boot.properties;

import com.lesson.spring.boot.properties.model.MultidataProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.lang.management.ManagementFactory;
import java.util.Locale;

/**
 *   配置中心加载
 *  {@code ConfigServicePropertySourceLocator}  {@code DiscoveryClientConfigServiceBootstrapConfiguration}
 *
 *
 *
 *
 *   bootstrap.properties
 *  {@code BootstrapApplicationListener}
 *
 *
 *   application.properties
 *  {@link ConfigFileApplicationListener}
 *
 *
 *
 *   yml 加载
 *   {@link YamlPropertySourceLoader}
 *
 *
 *   {@link ApplicationContextInitializer}
 *   调用时机
 *   SpringApplication#run(java.lang.String...)
 *     SpringApplication#prepareContext(org.springframework.context.ConfigurableApplicationContext, org.springframework.core.env.ConfigurableEnvironment, org.springframework.boot.SpringApplicationRunListeners, org.springframework.boot.ApplicationArguments, org.springframework.boot.Banner)
 *       SpringApplication#applyInitializers(org.springframework.context.ConfigurableApplicationContext)
 *
 *
 *    获取系统 部分信息
 *      > Starting PropertiesBootstrap on DESKTOP-6LN217U with PID 776 ...
 *    {@code StartupInfoLogger#getStartupMessage()}
 *
 * @see ConfigFileApplicationListener   可以扩展 自定义application.properties
 * @see EnvironmentPostProcessor
 * @author zhengshijun
 * @version created on 2018/12/22.
 */
@SpringBootApplication
@EnableConfigurationProperties({MultidataProperties.class})
public class PropertiesBootstrap {


    public static void main(String[] args){


        String name = ManagementFactory.getRuntimeMXBean().getName();


        SpringApplication.run(PropertiesBootstrap.class,args);


//        Locale.setDefault(Locale.US);
//        ConfigurableApplicationContext configurableApplicationContext =
//                SpringApplication.run(PropertiesBootstrap.class,args);
//
//
//        ConfigurableEnvironment configurableEnvironment =
//                configurableApplicationContext.getEnvironment();
//
//
//
//        MutablePropertySources sources = configurableEnvironment.getPropertySources();
//
//        sources.forEach(source->{
//            System.out.println("");
//            System.out.println(source.getName()+"-"+source.getSource());
//            System.out.println("");
//
//
//        });






    }
}
