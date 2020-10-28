package com.lesson.boot.mvc.code.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

/**
 * @author zhengshijun
 * @version created on 2020/10/28.
 */
@RestController
@RequestMapping("/index")
public class IndexController {
	public IndexController(){


	}

	/**
	 *
	 * @param header 请求头
	 * @return 返回
	 */
	@GetMapping("/home")
	public ResponseEntity<Map<String,String>> home(@RequestHeader Map<String,String> header){
		return ResponseEntity.of(Optional.of(header));
	}
}
