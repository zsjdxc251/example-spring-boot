package com.lesson.boot.cache;

import com.alibaba.fastjson.JSON;
import com.lesson.boot.cache.model.entity.Member;
import com.lesson.boot.cache.service.MemberService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheInterceptor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;

/**
 *
 *  {@link BeanFactoryPostProcessor}
 *  {@link BeanPostProcessor}
 *
 *  {@link CacheInterceptor}
 *
 *  {@code CacheOperationExpressionEvaluator#key(java.lang.String, org.springframework.context.expression.AnnotatedElementKey, org.springframework.expression.EvaluationContext)}
 *  {@code org.springframework.cache.interceptor.CacheAspectSupport#generateKey(org.springframework.cache.interceptor.CacheAspectSupport.CacheOperationContext, java.lang.Object)}
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@EnableCaching
@SpringBootApplication
public class BootCacheBootstrap {
	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(BootCacheBootstrap.class,args);


	}

	@Bean
	public ApplicationRunner applicationRunner(MemberService memberService){

		return args -> {
			Member member = memberService.getById(12L);
			System.out.println(JSON.toJSONString(member));

		};
	}
}
