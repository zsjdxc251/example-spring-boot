package com.lesson.boot.session.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhengshijun
 * @version created on 2018/11/16.
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/get")
    public ResponseEntity<String> get(HttpServletRequest request){
        request.getSession().setAttribute("ThreadName",Thread.currentThread().getName());

        return ResponseEntity.ok(Thread.currentThread().getName());
    }
}
