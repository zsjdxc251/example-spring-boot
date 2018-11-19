package com.lesson.boot.mvc.quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengshijun
 * @version created on 2018/11/18.
 */
@Controller
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/")
    public String home(){
        return "index";
    }
}
