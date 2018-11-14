package com.lesson.boot.mvc.configure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/get")
    public ResponseEntity<Double> get(Double number){

        return ResponseEntity.ok(number);
    }
}
