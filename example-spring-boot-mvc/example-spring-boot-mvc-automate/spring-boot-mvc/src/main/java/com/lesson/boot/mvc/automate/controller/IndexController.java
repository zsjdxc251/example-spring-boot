package com.lesson.boot.mvc.automate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhengshijun
 * @version created on 2018/11/19.
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/")
    public ModelAndView get(ModelAndView modelAndView){

        modelAndView.setViewName("index");

        modelAndView.addObject("message",Thread.currentThread().getName());
        return modelAndView;
    }
    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView){

        modelAndView.setViewName("home");

        modelAndView.addObject("message",Thread.currentThread().getName());
        return modelAndView;
    }
}
