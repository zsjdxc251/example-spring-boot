package com.lesson.boot.statemachine;

import com.lesson.boot.statemachine.entity.enums.Events;
import com.lesson.boot.statemachine.entity.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author zhengshijun
 * @version created on 2019/6/11.
 */
@SpringBootApplication
public class StateMachineBootstrap implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StateMachineBootstrap.class, args);
	}

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}
}
