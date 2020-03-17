package com.lesson.boot.listener.quickstart.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengshijun
 * @version created on 2020/3/17.
 */
@Slf4j
@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping("/get")
	public ResponseEntity<String> get(){
		log.info("MDC:{}", JSON.toJSONString(MDC.getCopyOfContextMap()));
		log.info("进来前");
		MDC.put("X-B3-TraceId","5566");
		MDC.put("traceId","5566");
		log.info("进来了");
		log.info("MDC:{}", JSON.toJSONString(MDC.getCopyOfContextMap()));
		return ResponseEntity.ok(MDC.get("X-B3-TraceId"));
	}
}
