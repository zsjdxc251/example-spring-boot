package com.lesson.boot.jdbc;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author zhengshijun
 * @version created on 2020/2/14.
 */
@SpringBootApplication
public class JdbcBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(JdbcBootstrap.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner1(BalanceInfoService balanceInfoService) {
		return arguments -> {

			CountDownLatch countDownLatch = new CountDownLatch(1);
			IntStream.range(0,10).forEach(i->{
				new Thread(()->{
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					BigDecimal bigDecimal = BigDecimal.valueOf(200);
					if (i%2== 0){
						bigDecimal = bigDecimal.negate();
					}
					balanceInfoService.handleFault(465914L, -1L, bigDecimal, "test1");
				}).start();
			});

			IntStream.range(0,10).forEach(i->{
				new Thread(()->{
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					BigDecimal bigDecimal = BigDecimal.valueOf(200).negate();
					if (i%2 == 0){
						bigDecimal = bigDecimal.negate();
					}
					balanceInfoService.handleFault(465914L, -1L, bigDecimal, "test2");
				}).start();
			});
			countDownLatch.countDown();
		};
	}

}
