package com.lesson.spring.boot.redis.service;

import com.lesson.spring.boot.redis.distlock.MutexLock;
import org.springframework.stereotype.Service;

/**
 * @author zhengshijun
 * @version created on 2020/6/2.
 */
@Service
public class MemberService {


	@MutexLock(key = "#id")
	public Object getById(Long id){

		return id;
	}
}
