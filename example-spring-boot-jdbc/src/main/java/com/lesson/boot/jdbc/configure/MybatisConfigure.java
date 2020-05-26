package com.lesson.boot.jdbc.configure;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhengshijun
 * @version created on 2019/1/11.
 */
@Configuration
@MapperScan("com.lesson.boot.jdbc.mapper")
@EnableTransactionManagement
public class MybatisConfigure {

	/**
	 * 注册Mybaits 分页插件 Bean
	 *
	 * @return 返回对象
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}
}
