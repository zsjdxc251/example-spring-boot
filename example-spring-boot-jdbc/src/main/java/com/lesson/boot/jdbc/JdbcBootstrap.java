package com.lesson.boot.jdbc;

import com.baomidou.mybatisplus.core.MybatisMapperAnnotationBuilder;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.lesson.boot.jdbc.service.MemberService;
import com.lesson.boot.jdbc.service.OrderService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 *  {@link MybatisMapperAnnotationBuilder#parse()}
 *
 *  {@link AbstractSqlInjector#inspectInject(org.apache.ibatis.builder.MapperBuilderAssistant, java.lang.Class)}
 *
 *  {@link AbstractSqlInjector#getMethodList(java.lang.Class)}
 *
 *  设置事务排序
 *  {@link EnableTransactionManagement#order()}
 *
 * {@link DefaultSqlInjector}
 * @author zhengshijun
 * @version created on 2020/2/14.
 */
@SpringBootApplication
public class JdbcBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(JdbcBootstrap.class, args);
	}
	@Bean
	public ApplicationRunner applicationRunner(OrderService orderService) {
		return arguments -> {
			ApplicationPid applicationPid = new ApplicationPid();
			System.out.println(applicationPid.toString());
			orderService.exist();
		};
	}


}
