package com.lesson.boot.mvc.encrypt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/6/5.
 */
@RestController
@RequestMapping("/")
public class IndexController {


	/**
	 *  主页
	 * @param header
	 * @return
	 */
	@GetMapping("/home")
	public ResponseEntity<Map<String,String>> home(@RequestHeader Map<String,String> header){

		return ResponseEntity.ok(header);
	}
}
