package com.lesson.boot.mvc.servlet.natives.servlet.support;

import com.lesson.boot.mvc.servlet.natives.servlet.AsyncServlet;
import com.lesson.boot.mvc.servlet.natives.servlet.configure.CustomWebMvcConfigure;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
public class DefAbstractAnnotationServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] classes = {CustomWebMvcConfigure.class};
        return classes;
    }

    @Override
    protected String[] getServletMappings() {

        String[] servletMappings = {"/"};
        return servletMappings;
    }
}
