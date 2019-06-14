package com.lesson.boot.statemachine.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */
@ShellComponent()
public class TranslationCommands {

	@ShellMethod(value = "Add two integers together.",key = "sum")
	public int add(int a, int b) {
		return a + b;
	}
	@ShellMethod(value = "Add two integers together." ,prefix="-")
	public int add1(int a, @ShellOption("--c") int b) {
		System.out.println(a +"-" + b);
		return a + b;
	}


}
