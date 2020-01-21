package com.lesson.spring.boot.transaction.service;

import com.lesson.spring.boot.transaction.module.MethodOne;
import com.lesson.spring.boot.transaction.module.MethodTwo;
import org.springframework.stereotype.Service;

/**
 * @author zhengshijun
 * @version created on 2020/1/21.
 */
@Service
public class DoingService {

	@MethodOne
	@MethodTwo
	public void execute(){


	}
}
