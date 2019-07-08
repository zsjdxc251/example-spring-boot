package com.lesson.boot.management.quickstart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/7/5.
 */
@RestController
public class IndexController {

	@GetMapping("/home")
	public ResponseEntity<Map<String, Object>> home(@RequestHeader Map<String, Object> headers) {

		return ResponseEntity.ok(headers);
	}
}
