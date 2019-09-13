package com.lesson.boot.statemachine.zookeeper;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */
@SpringBootApplication
public class StateMachineZookeeperBootstrap {

	private static StateMachine<ZooKeeper.States, String> stateMachine;
	public static void main(String[] args) {


		SpringApplication.run(StateMachineZookeeperBootstrap.class, args);

	}


}
