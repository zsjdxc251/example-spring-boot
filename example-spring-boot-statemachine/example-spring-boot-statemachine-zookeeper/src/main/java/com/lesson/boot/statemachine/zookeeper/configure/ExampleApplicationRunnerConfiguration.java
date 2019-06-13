package com.lesson.boot.statemachine.zookeeper.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeExceptionMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.shell.ExitRequest;
import org.springframework.shell.Input;
import org.springframework.shell.InputProvider;
import org.springframework.shell.Shell;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */
public class ExampleApplicationRunnerConfiguration {
	@Autowired
	private Shell shell;

	@Bean
	public CommandLineRunner exampleCommandLineRunner(ConfigurableEnvironment environment) {
		return new ExampleCommandLineRunner(shell, environment);
	}

	@Bean
	public ExitCodeExceptionMapper exitCodeExceptionMapper() {
		return exception -> {
			Throwable e = exception;
			while (e != null && !(e instanceof ExitRequest)) {
				e = e.getCause();
			}
			return e == null ? 1 : ((ExitRequest) e).status();
		};
	}
}

/**
 * Example CommandLineRunner that shows how overall shell behavior can be customized. In
 * this particular example, any program (process) arguments are assumed to be shell
 * commands that need to be executed (and the shell then quits).
 */
@Order(InteractiveShellApplicationRunner.PRECEDENCE - 2)
class ExampleCommandLineRunner implements CommandLineRunner {

	private Shell shell;

	private final ConfigurableEnvironment environment;

	public ExampleCommandLineRunner(Shell shell, ConfigurableEnvironment environment) {
		this.shell = shell;
		this.environment = environment;
	}

	@Override
	public void run(String... args) throws Exception {
		List<String> commandsToRun = Arrays.stream(args)
				.filter(w -> !w.startsWith("@"))
				.collect(Collectors.toList());
		if (!commandsToRun.isEmpty()) {
			InteractiveShellApplicationRunner.disable(environment);
			shell.run(new StringInputProvider(commandsToRun));
		}
	}
}

class StringInputProvider implements InputProvider {

	private final List<String> words;

	private boolean done;

	public StringInputProvider(List<String> words) {
		this.words = words;
	}

	@Override
	public Input readInput() {
		if (!done) {
			done = true;
			return new Input() {
				@Override
				public List<String> words() {
					return words;
				}

				@Override
				public String rawText() {
					return StringUtils.collectionToDelimitedString(words, " ");
				}
			};
		}
		else {
			return null;
		}
	}
}
