package com.lesson.spring.boot.properties;

import com.lesson.spring.boot.properties.model.SingledataProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;

/**
 * @author zhengshijun
 * @version created on 2018/12/22.
 */
@Component
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {

        System.out.println(beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

        if (StringUtils.equals(beanName,"spring.data-com.lesson.spring.boot.properties.model.MultidataProperties")){

            System.out.println("");
        }
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName,"spring.data-com.lesson.spring.boot.properties.model.MultidataProperties")){

            System.out.println("");

//            try {
//                pds[1].getWriteMethod().invoke(bean,new ArrayList<SingledataProperties>());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName,"spring.data-com.lesson.spring.boot.properties.model.MultidataProperties")){

            System.out.println("");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (StringUtils.equals(beanName,"spring.data-com.lesson.spring.boot.properties.model.MultidataProperties")){

            System.out.println("");
        }
        return null;
    }
}
