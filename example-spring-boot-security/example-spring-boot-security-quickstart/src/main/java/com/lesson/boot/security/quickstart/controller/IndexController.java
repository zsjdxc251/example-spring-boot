package com.lesson.boot.security.quickstart.controller;

import com.lesson.boot.security.quickstart.eitity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

/**
 * @author zhengshijun
 * @version created on 2018/12/19.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/home")
    public ResponseEntity<String> home(@SessionAttribute UserInfo userInfo, @CookieValue String id){



        return ResponseEntity.ok("");
    }

    @GetMapping("/getName")
    public ResponseEntity<String> getThreadName(){
        return ResponseEntity.ok(Thread.currentThread().getName());
    }


    @GetMapping("/login")
    public ResponseEntity<String> login(String username ,String password){


        Authentication request = new UsernamePasswordAuthenticationToken(username, password);

        Authentication result = authenticationManager.authenticate(request);

        SecurityContextHolder.getContext().setAuthentication(request);


        return ResponseEntity.ok("");

    }
}
