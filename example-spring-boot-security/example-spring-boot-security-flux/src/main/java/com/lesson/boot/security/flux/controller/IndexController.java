package com.lesson.boot.security.flux.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/5/24.
 */
@RestController
public class IndexController {

	@GetMapping("/abc/1")
	public ResponseEntity<Map<String,String>> abc(@RequestHeader Map<String,String> header){

		return ResponseEntity.ok(header);
	}


	@GetMapping("/app/1")
	public ResponseEntity<Map<String,String>> app(@RequestHeader Map<String,String> header){

		return ResponseEntity.ok(header);
	}

}
