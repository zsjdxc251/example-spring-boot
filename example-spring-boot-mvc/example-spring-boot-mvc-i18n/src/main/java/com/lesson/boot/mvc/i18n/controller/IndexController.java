package com.lesson.boot.mvc.i18n.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;
import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/9/2.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private  LocaleResolver localeResolver;

    @GetMapping("/home")
    public ResponseEntity<Map<String,String>> home(@RequestHeader Map<String,String> header, Locale locale){

        return ResponseEntity.ok(header);
    }
}
