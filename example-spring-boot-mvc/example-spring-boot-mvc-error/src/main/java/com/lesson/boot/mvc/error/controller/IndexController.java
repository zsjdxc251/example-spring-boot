package com.lesson.boot.mvc.error.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2018/11/12.
 */
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/get")
    public ResponseEntity<String> get(Integer user){
        if (user == null){
            throw new RuntimeException();
        }
        return ResponseEntity.ok(JSON.toJSONString(user));
    }
}
