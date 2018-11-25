package com.lesson.boot.mvc.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Properties;

/**
 * @author zhengshijun
 * @version created on 2018/11/23.
 */
@Controller
@RequestMapping("/props")
public class PropertiesController {



    @PostMapping("/")
    public Properties convert(Properties properties) {


        return properties;
    }
}
