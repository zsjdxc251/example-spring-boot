package com.lesson.boot.mvc.automate.war.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/3/9.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<Map<String,String>> index(@RequestHeader Map<String,String> header){


        return ResponseEntity.ok(header);
    }
}
