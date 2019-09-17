package com.lesson.boot.cache.service;

import com.lesson.boot.cache.model.entity.Member;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Service
public class MemberService implements DisposableBean {


	@Cacheable(value = "getById", key = "targetClass + methodName +#id")
	public Member getById(Long id) {


		return Member.builder().id(id).username("zsj").password("123456").build();
	}

	@Override
	public void destroy() throws Exception {

		System.out.println("destroy:" + Thread.currentThread().getName());

	}
}
