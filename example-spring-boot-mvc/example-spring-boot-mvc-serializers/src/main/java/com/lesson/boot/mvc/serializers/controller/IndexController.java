package com.lesson.boot.mvc.serializers.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/get")
    public ResponseEntity<Map<String,String>> get(){
        return ResponseEntity.ok(ImmutableMap.of("threadName",Thread.currentThread().getName()));
    }


    @PostMapping("/post")
    public ResponseEntity<Map<String,String>> post(@RequestBody Map<String,String> params){
        return ResponseEntity.ok(params);
    }
}
