package com.lesson.boot.mvc.content.negotiation.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @ResponseBody
    @GetMapping(value = "/get")
    public ResponseEntity<Map<String,String>> get(@RequestHeader Map<String,String> header){

        return ResponseEntity.ok(header);
    }



    @GetMapping("/load")
    public ModelAndView load(ModelAndView modelAndView){


        modelAndView.setViewName("index");
        modelAndView.addObject("message","hello world");

        return modelAndView;
    }
}
