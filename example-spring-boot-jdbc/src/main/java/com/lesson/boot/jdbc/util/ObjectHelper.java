package com.lesson.boot.jdbc.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * @author zhengshijun
 * @version created on 2019/10/17.
 */
public class ObjectHelper {

	public static boolean equals(Object a, Object... bs) {
		if (bs == null || bs.length == 0) {
			return a == null;
		}
		for (Object b : bs) {
			if (Objects.equals(a, b)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断如果是空的返回默认值
	 *
	 * @param t            原始值
	 * @param defaultValue 默认值
	 * @param <T>          泛型
	 * @return 泛型对象
	 */
	public static <T> T isNull(T t, T defaultValue) {
		return Objects.isNull(t) ? defaultValue : t;
	}

	/**
	 * 字符串转 Long
	 *
	 * @param value 字符串
	 * @return 返回指定值
	 */
	private static Long stringToLong(String value) {
		Optional<Long> optional =
				Optional.ofNullable(value).filter(StringUtils::isNumeric).map(Long::valueOf);
		return optional.orElse(0L);
	}
}
