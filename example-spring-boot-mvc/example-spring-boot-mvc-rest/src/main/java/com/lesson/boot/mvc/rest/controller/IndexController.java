package com.lesson.boot.mvc.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2020/10/23.
 */
@RestController
@RequestMapping("/index")
public class IndexController {


	@GetMapping("/home")
	public ResponseEntity<String> home(){

		return ResponseEntity.ok("123");
	}
}
