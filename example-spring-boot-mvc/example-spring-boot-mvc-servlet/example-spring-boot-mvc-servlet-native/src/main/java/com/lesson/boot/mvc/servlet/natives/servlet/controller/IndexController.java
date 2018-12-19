package com.lesson.boot.mvc.servlet.natives.servlet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/get")
    public ResponseEntity<String> get(){

        return ResponseEntity.ok(Thread.currentThread().getName());
    }
}
