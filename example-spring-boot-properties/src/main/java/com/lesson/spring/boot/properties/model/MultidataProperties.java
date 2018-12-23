package com.lesson.spring.boot.properties.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.Properties;

/**
 * @author zhengshijun
 * @version created on 2018/12/22.
 */
@Getter
@Setter
@ConfigurationProperties("spring.data2")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MultidataProperties  {


    private String name;


    private List<Properties> item;

    public MultidataProperties(){

        System.out.println("");
    }




}
