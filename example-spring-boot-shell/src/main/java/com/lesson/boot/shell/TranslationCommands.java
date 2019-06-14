package com.lesson.boot.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

/**
 * @author zhengshijun
 * @version created on 2019/6/12.
 */
@ShellComponent()
public class TranslationCommands {


	/**
	 *   sum 1 2
	 * @param a
	 * @param b
	 * @return
	 */
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
