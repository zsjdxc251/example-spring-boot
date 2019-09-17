package com.lesson.boot.cache.configure;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Configuration
public class SpringContextConfigure implements DisposableBean {

	private SimpleApplicationEventMulticaster eventMulticaster;
	private ExecutorService executor;


	public SpringContextConfigure(SimpleApplicationEventMulticaster eventMulticaster) {
		this.eventMulticaster = eventMulticaster;
		executor = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5000),
				new ThreadFactoryBuilder().setNameFormat("custom-event-%s").build()
		);
		eventMulticaster.setTaskExecutor(executor);
	}

	@Override
	public void destroy() throws Exception {
		if (executor != null){
			executor.shutdown();
		}

	}
}
