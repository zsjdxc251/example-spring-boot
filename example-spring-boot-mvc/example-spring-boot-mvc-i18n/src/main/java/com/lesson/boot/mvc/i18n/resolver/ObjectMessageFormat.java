package com.lesson.boot.mvc.i18n.resolver;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Array;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.*;

/**
 * 格式化 for POJO/Map the {name}
 * {@link Formatter#format(String, Object...)} {@link String#format(String, Object...)}
 *
 * @author zhengshijun
 * @version created on 2019/2/25.
 * @see java.text.MessageFormat#format(String, Object...)
 */
public class ObjectMessageFormat extends Format {

	private String MATCHER_SPACE_PREFIX = "{";

	private String MATCHER_SPACE_SUFFIX = "}";

	protected Object values;

	private String[] arguments;

	private Integer[] offsets;

	public ObjectMessageFormat(Object values) {
		this.values = values;
	}

	public ObjectMessageFormat(String matcherSpacePrefix, String matcherSpaceSuffix, Object values) {
		this.MATCHER_SPACE_PREFIX = matcherSpacePrefix;
		this.MATCHER_SPACE_SUFFIX = matcherSpaceSuffix;
		this.values = values;
	}

	public static String format(String patten, Object values) {
		ObjectMessageFormat objectFormat = new ObjectMessageFormat(values);
		return objectFormat.format(patten);
	}

	@Override
	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {

		String pattern = processPattern(String.valueOf(obj));


		int lastIndex = 0;
		for (int i = 0; i < offsets.length; i++) {
			toAppendTo.append(StringUtils.substring(pattern, lastIndex, offsets[i]));
			lastIndex = offsets[i];
			if (arguments.length > i) {
				String value = formatObject(arguments[i]);
				if (StringUtils.isNotBlank(value)) {
					toAppendTo.append(value);
				}
			}
		}

		return toAppendTo;
	}

	protected String formatObject(String argument) {
		if (values instanceof Map) {
			@SuppressWarnings("unchecked")
			Map<String, Object> mapValues = Map.class.cast(values);
			return String.valueOf(mapValues.get(argument));
		}
		if (values.getClass().isArray()) {
			if (StringUtils.isNumeric(argument)) {
				Object value = Array.get(values, NumberUtils.toInt(argument));
				return String.valueOf(value);
			}
			return null;
		} else if (values instanceof List) {
			List<?> list = List.class.cast(values);
			if (StringUtils.isNumeric(argument)) {
				Object value = list.get(NumberUtils.toInt(argument));
				return String.valueOf(value);
			}
			return null;
		} else if (values instanceof Set) {
			throw new IllegalArgumentException();
		} else {
			Object value;
			try {
				java.lang.reflect.Field field = values.getClass().getDeclaredField(argument);
				field.setAccessible(true);
				value = field.get(values);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				value = null;
			}
			return String.valueOf(value);
		}
	}

	private String processPattern(String pattern) {

		StringBuilder toAppendTo = new StringBuilder();

		List<String> arguments = new ArrayList<>(16);
		List<Integer> offsets = new ArrayList<>(16);
		int index = 0;
		while (true) {
			int prefixIndex = pattern.indexOf(MATCHER_SPACE_PREFIX, index);
			if (prefixIndex < 0) {
				if (index < pattern.length()) {
					toAppendTo.append(StringUtils.substring(pattern, index, pattern.length()));
					offsets.add(toAppendTo.length());
				}
				break;
			}
			int suffixIndex = pattern.indexOf(MATCHER_SPACE_SUFFIX, prefixIndex + MATCHER_SPACE_PREFIX.length());
			if (suffixIndex < 0) {
				if (index < pattern.length()) {
					toAppendTo.append(StringUtils.substring(pattern, index, pattern.length()));
					offsets.add(toAppendTo.length());
				}
				break;
			}
			String matchName = StringUtils.substring(pattern, prefixIndex, suffixIndex + 1);
			String argumentName = StringUtils.substring(matchName, StringUtils.indexOf(matchName, MATCHER_SPACE_PREFIX) + (MATCHER_SPACE_PREFIX.length()), StringUtils.indexOf(matchName, MATCHER_SPACE_SUFFIX));
			arguments.add(argumentName);
			toAppendTo.append(StringUtils.substring(pattern, index, prefixIndex));
			offsets.add(toAppendTo.length());
			index = suffixIndex + MATCHER_SPACE_SUFFIX.length();
		}
		this.arguments = new String[arguments.size()];
		arguments.toArray(this.arguments);
		this.offsets = new Integer[offsets.size()];
		offsets.toArray(this.offsets);
		return toAppendTo.toString();

	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		return null;
	}



}
