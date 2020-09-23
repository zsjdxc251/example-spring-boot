package com.lesson.boot.sharding.configure.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;

/**
 * @author zhengshijun
 * @version created on 2020/8/11.
 */
@Data
@ConfigurationProperties(prefix = "spring.shardingsphere.datasource")
public class DataSourceProperties {

	private DataSource dsMaster;
}
