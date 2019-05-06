package com.lesson.boot.docs.quickstart.properties;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 *
 *
 * @author zhengshijun
 * @version created on 2019/5/6.
 */
@Data
@ConfigurationProperties("app.system")
@Validated
public class AppSystemProperties {

	@DurationUnit(ChronoUnit.SECONDS)
	private Duration sessionTimeout = Duration.ofSeconds(30);

	private Duration readTimeout = Duration.ofMillis(1000);

	//@NonNull
	private String address;




}
