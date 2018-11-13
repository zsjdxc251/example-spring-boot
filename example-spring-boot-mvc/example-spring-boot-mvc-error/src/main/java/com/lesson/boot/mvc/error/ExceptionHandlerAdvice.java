package com.lesson.boot.mvc.error;

import com.lesson.boot.mvc.error.controller.IndexController;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhengshijun
 * @version created on 2018/11/13.
 */
@RestControllerAdvice(basePackageClasses=IndexController.class)
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handler(HttpServletRequest request, HttpServletResponse response, Throwable ex){
        log.error(StringUtils.EMPTY,ex);
        return ResponseEntity.status(response.getStatus()).body("发送错误");
    }
}
