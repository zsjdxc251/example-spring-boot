package com.lesson.boot.mvc.content.negotiation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author zhengshijun
 * @version created on 2018/11/14.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/get")
    public ResponseEntity<String> get(Date data){

        return ResponseEntity.ok(Thread.currentThread().getName());
    }
}
