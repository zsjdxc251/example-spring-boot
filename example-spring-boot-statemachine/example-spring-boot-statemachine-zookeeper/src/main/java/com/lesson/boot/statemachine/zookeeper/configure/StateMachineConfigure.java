package com.lesson.boot.statemachine.zookeeper.configure;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.ensemble.StateMachineEnsemble;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.statemachine.zookeeper.ZookeeperStateMachineEnsemble;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */

public class StateMachineConfigure extends StateMachineConfigurerAdapter<String, String> {

	@Override
	public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
		config
				.withConfiguration()
				.listener(listener());
		config

				.withDistributed()
				.ensemble(stateMachineEnsemble());
	}


	@Override
	public void configure(StateMachineStateConfigurer<String, String> states)
			throws Exception {
		states
				.withStates()
				.initial("LOCKED")
				.state("UNLOCKED");
	}

	@Override
	public void configure(StateMachineTransitionConfigurer<String, String> transitions)
			throws Exception {
		transitions
				.withExternal()
				.source("LOCKED")
				.target("UNLOCKED")
				.event("COIN")
				.and()
				.withExternal()
				.source("UNLOCKED")
				.target("LOCKED")
				.event("PUSH");
	}


	public StateMachineEnsemble<String, String> stateMachineEnsemble() throws Exception {
		return new ZookeeperStateMachineEnsemble<>(curatorClient(), "/foo");
	}


	public CuratorFramework curatorClient() throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.builder().defaultData(new byte[0])
				.retryPolicy(new ExponentialBackoffRetry(1000, 3))
				.connectString("localhost:2181").build();
		client.start();
		return client;
	}


	public StateMachineListener<String, String> listener() {
		return new StateMachineListenerAdapter<String, String>() {
			@Override
			public void transition(Transition<String, String> transition) {

				System.out.println(transition.getTarget());
			}
		};
	}
}
