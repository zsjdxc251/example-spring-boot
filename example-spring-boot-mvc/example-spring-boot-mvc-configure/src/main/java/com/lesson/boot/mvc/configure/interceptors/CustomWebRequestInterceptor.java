package com.lesson.boot.mvc.configure.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
public class CustomWebRequestInterceptor implements WebRequestInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CustomWebRequestInterceptor.class);

    @Override
    public void preHandle(WebRequest request) throws Exception {
        log.info("preHandle");

    }

    @Override
    public void postHandle(WebRequest request, ModelMap model) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest request, Exception ex) throws Exception {

    }
}
