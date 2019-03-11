package com.lesson.boot.jmx.quickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *  远程连接 ：service:jmx:rmi://127.0.0.1:8896/jndi/rmi://127.0.0.1:8896/jmxrmi
 *
 *   -Djava.rmi.server.hostname=127.0.0.1 -Dcom.sun.management.jmxremote.port=8899 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=true
 *
 * @see JAVA_HOME/jre/lib/management/jmxremote.access 和 JAVA_HOME/jre/lib/management/jmxremote.password
 * @author zhengshijun
 * @version created on 2019/3/11.
 */
@SpringBootApplication
public class BootJmxQuickstartBootstrap {
	public static void main(String[] args) {
		SpringApplication.run(BootJmxQuickstartBootstrap.class,args);
	}
}
