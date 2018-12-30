package com.lesson.boot.security.basic.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2018/12/30.
 */
@Slf4j
@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestHeader(required = false) Map<String,String> header){

        log.info("header:{}", JSON.toJSONString(header));
        return ResponseEntity.ok(Thread.currentThread().getName());
    }
}
