package com.lesson.boot.mvc.quickstart;

import com.google.common.collect.ImmutableMap;
import com.lesson.boot.mvc.quickstart.controller.IndexController;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhengshijun
 * @version created on 2018/11/18.
 */
@ControllerAdvice(basePackageClasses= IndexController.class)
public class MyControllerAdvice {


    @InitBinder
    public void initData(WebDataBinder webDataBinder){

    }


    @ModelAttribute("sessionId")
    public String sessionId(@CookieValue(value="sesssion",required = false)String sessionId){
        return sessionId;
    }


    @ExceptionHandler(Exception.class)
    public ModelAndView executeException(Throwable ex){

        return new ModelAndView("/error", ImmutableMap.of("errorMessage",ex.getMessage()));
    }
}
