# example-spring-boot


## 核心类
  * `org.springframework.boot.BeanDefinitionLoader`





## Spring Boot 生命周期

>Spring Boot 准备阶段
>​    Bean的来源
>​    推倒是Web还是其他程序
>​	推倒Main 使用异常栈
>​	加载事件
>​	
>Spring Boot 运行阶段
>
>​    事件监听

## 基础组件
* `CommandLineRunner`
* `ApplicationRunner`



## Spring boot 部署

[官方文档](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#deployment-script-customization-when-it-runs)

```xml
<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>${spring.boot.version}</version>
				<configuration>
					<executable>true</executable>
				</configuration>
				<executions>
					<execution>
						<goals>
							<goal>repackage</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
```



* 生成`app.jar` 更名为`app` 

* 在根目录新建`app.conf` 

  * ```properties
    JAVA_OPTS="-Xmx256M"
    PID_FOLDER=./
    LOG_FOLDER=./
    RUN_ARGS=--server.port=0
    ```

    **详细配置参考官方文档**

  **`app.conf`文件名必须和转换后的`app.jar`文件名一致**

* `./app {start|stop|force-stop|restart|force-reload|status|run}` 操作命令