package com.lesson.spring.boot.properties;

import com.lesson.spring.boot.properties.model.MultidataProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Locale;

/**
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


        Locale.setDefault(Locale.US);
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(PropertiesBootstrap.class,args);


        ConfigurableEnvironment configurableEnvironment =
                configurableApplicationContext.getEnvironment();



        MutablePropertySources sources = configurableEnvironment.getPropertySources();

        sources.forEach(source->{
            System.out.println("");
            System.out.println(source.getName()+"-"+source.getSource());
            System.out.println("");


        });






    }
}
