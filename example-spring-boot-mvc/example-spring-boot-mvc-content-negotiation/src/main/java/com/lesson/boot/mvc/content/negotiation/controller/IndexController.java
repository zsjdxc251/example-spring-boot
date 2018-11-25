package com.lesson.boot.mvc.content.negotiation.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @ResponseBody
    @GetMapping(value = "/get",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> get(Date data){

        return ResponseEntity.ok(Thread.currentThread().getName());
    }



    @GetMapping("/load")
    public ModelAndView load(ModelAndView modelAndView){


        modelAndView.setViewName("index");
        modelAndView.addObject("message","hello world");

        return modelAndView;
    }
}
