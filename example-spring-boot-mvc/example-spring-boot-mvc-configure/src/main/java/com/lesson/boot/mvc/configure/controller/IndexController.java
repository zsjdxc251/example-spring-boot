package com.lesson.boot.mvc.configure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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





    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader(value = "Accept-Language",required = false)String acceptLanguage) {

        return acceptLanguage;
    }

    @ModelAttribute("giteeSession")
    public String giteeSession(@CookieValue(value = "gitee-session-n",required=false) String giteeSession) {
        return giteeSession;
    }
}
