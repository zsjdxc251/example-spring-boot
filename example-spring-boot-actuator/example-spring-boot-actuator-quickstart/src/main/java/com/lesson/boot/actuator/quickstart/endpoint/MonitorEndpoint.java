package com.lesson.boot.actuator.quickstart.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.AbstractReactiveHealthIndicator;
import org.springframework.boot.actuate.health.ReactiveHealthIndicator;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.SimpleInfoContributor;
import org.springframework.stereotype.Component;

/**
 *
 * @see <a href="https://blog.csdn.net/alinyua/article/details/80009435"/>
 *
 *    默认配置路径
 *    management.server.address = http://localhost
 *    management.server.port=-1        禁用HTTP端点
 *    management.endpoints.web.base-path=/manage
 *    management.server.port=8081
 *    management.endpoints.web.path-mapping.health=healthcheck
 *
 *
 *    server.port=8443
 *    server.ssl.enabled=true
 *    server.ssl.key-store=classpath:store.jks
 *    server.ssl.key-password=secret
 *    management.server.port=8080
 *    management.server.ssl.enabled=false
 *
 *   {@link DeleteOperation}
 *   {@link WriteOperation}
 *   {@link ReadOperation}
 *
 *   {@link Selector} 参数
 *
 *
 *   {@link ServletEndpoint}
 *   {@link ControllerEndpoint}
 *   {@link RestControllerEndpoint}
 *   {@link WebEndpoint}
 *
 *
 *
 *
 *    跨域支撑
 *    management.endpoints.web.cors.allowedRedisReactiveHealthIndicator-origins=http://example.com
 *    management.endpoints.web.cors.allowed-methods=GET,POST
 *
 *
 *   management.health.defaults.enabled
 *
 *   监控检查引用 实现抽象类 {@link AbstractHealthIndicator}  实现 {@code org.springframework.boot.actuate.redis.RedisHealthIndicator}
 *
 *
 *
 *   {@link ReactiveHealthIndicator}  {@link AbstractReactiveHealthIndicator} 实现 {@code org.springframework.boot.actuate.redis.RedisReactiveHealthIndicator}
 *
 *    /info
 *    {@link InfoContributor } 实现 {@link SimpleInfoContributor}
 *
 *    或者在prpperties 中配置 info:
 *
 *
 *
 * @author zhengshijun
 * @version creatWebEndpointed on 2019/3/1.
 */
@Component
@Endpoint(id = "monitor")
public class MonitorEndpoint {



	@WriteOperation
	public String registry(@Selector String action) {

		return "unknown action [" + action + "]";
	}

	@ReadOperation
	public String getter(@Selector String action) {

		return "unknown action [" + action + "]";
	}
}
