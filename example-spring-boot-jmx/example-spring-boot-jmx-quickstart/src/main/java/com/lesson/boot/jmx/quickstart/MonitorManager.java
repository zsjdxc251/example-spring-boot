package com.lesson.boot.jmx.quickstart;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @version created on 2019/3/11.
 */
@Component
@ManagedResource(objectName = "bean:name=com.lesson.boot.jmx.quickstart.MonitorManager", description = "描述")
public class MonitorManager {


	@ManagedOperation
	public void flush() {

	}



}
