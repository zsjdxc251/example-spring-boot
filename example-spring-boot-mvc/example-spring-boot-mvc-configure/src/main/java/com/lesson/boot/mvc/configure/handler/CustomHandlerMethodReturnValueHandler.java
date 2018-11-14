package com.lesson.boot.mvc.configure.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
public class CustomHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private static final Logger log = LoggerFactory.getLogger(CustomHandlerMethodReturnValueHandler.class);

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {

        log.info("supportsReturnType");
        return false;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        log.info("handleReturnValue");
    }
}
