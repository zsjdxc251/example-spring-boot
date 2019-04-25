package com.lesson.boot.mvc.automate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * @author zhengshijun
 * @version created on 2019/4/25.
 */
@Controller
public class WelcomeController {

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", Thread.currentThread().getName());
		return "welcome";
	}
}
