package com.lesson.boot.jdbc.util;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * @author zhengshijun
 * @version created on 2019/8/26.
 */
public class DecimalPlus {

	private static final int ROUND_MODE = BigDecimal.ROUND_DOWN;


	private BigDecimal decimal;

	private DecimalPlus(BigDecimal decimal) {
		this.decimal = convertBigDecimal(decimal);
	}

	public static DecimalPlus of(BigDecimal arg0) {
		return new DecimalPlus(arg0);
	}

	public DecimalPlus add(BigDecimal arg0) {
		decimal = decimal.add(convertBigDecimal(arg0));
		return this;
	}

	public DecimalPlus add(Supplier<Boolean> predicate, BigDecimal arg0) {
		if (Objects.equals(predicate.get(), Boolean.TRUE)) {
			decimal = decimal.add(convertBigDecimal(arg0));
		}
		return this;
	}

	public DecimalPlus add(Boolean verify, BigDecimal arg0) {
		if (Objects.equals(verify, Boolean.TRUE)) {
			decimal = decimal.add(convertBigDecimal(arg0));
		}
		return this;
	}

	public DecimalPlus subtract(BigDecimal arg0) {
		decimal = decimal.subtract(convertBigDecimal(arg0));
		return this;
	}

	public DecimalPlus multiply(BigDecimal arg0) {
		decimal = decimal.multiply(convertBigDecimal(arg0));
		return this;
	}

	public DecimalPlus divide(BigDecimal arg0) {
		if (arg0 == null || Objects.equals(arg0.doubleValue(), BigDecimal.ZERO.doubleValue())) {
			decimal = BigDecimal.ZERO;
		} else {
			decimal = decimal.divide(arg0, ROUND_MODE);
		}
		return this;
	}

	public DecimalPlus divide(BigDecimal arg0, int scale) {

		this.decimal = decimal.divide(convertBigDecimal(arg0), scale, ROUND_MODE);

		return this;
	}

	private static BigDecimal convertBigDecimal(BigDecimal decimal) {
		return decimal == null ? BigDecimal.ZERO : decimal;
	}

	/**
	 * 转换为 {@link BigDecimal}
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	private static Pair<BigDecimal, BigDecimal> convertBigDecimal(Number arg0, Number arg1) {

		return Pair.of(arg0 == null ? BigDecimal.ZERO : BigDecimal.valueOf(arg0.doubleValue()),
				arg1 == null ? BigDecimal.ZERO : BigDecimal.valueOf(arg1.doubleValue()));
	}

	/**
	 * 转换为 {@link Integer}
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	private static <T extends Number> Pair<Long, Long> convertLong(T arg0, T arg1) {

		return Pair.of(arg0 == null ? 0 : arg0.longValue(), arg1 == null ? 0 : arg1.longValue());
	}


	private static BigInteger convertBigInteger(BigDecimal decimal) {
		return decimal == null ? BigInteger.ZERO : decimal.toBigInteger();
	}

	public BigDecimal value() {
		return this.decimal;
	}

	@Override
	public String toString() {
		return decimal.toString();
	}


	/**
	 * 相等   ==
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean eq(BigDecimal arg1) {
		return decimal.compareTo(convertBigDecimal(arg1)) == BigDecimal.ZERO.intValue();
	}

	/**
	 * 不相等 !=
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean ne(BigDecimal arg1) {
		return !eq(decimal, arg1);
	}

	/**
	 * 大于 >
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean gt(BigDecimal arg1) {
		return decimal.compareTo(convertBigDecimal(arg1)) == BigDecimal.ONE.intValue();
	}

	/**
	 * 大于 或 等于  >=
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean gtOrEq(BigDecimal arg1) {

		return gt(decimal, arg1) || eq(decimal, arg1);
	}


	/**
	 * 小于 <
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean lt(BigDecimal arg1) {


		return convertBigDecimal(arg1).compareTo(decimal) == BigDecimal.ONE.intValue();
	}


	/**
	 * 小于等于 <=
	 *
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public boolean ltOrEq(BigDecimal arg1) {

		return lt(decimal, arg1) || eq(decimal, arg1);
	}

	/**
	 * 相等   ==
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean eq(BigDecimal arg0, BigDecimal arg1) {
		Pair<BigDecimal, BigDecimal> numberPair = convertBigDecimal(arg0, arg1);

		return equals(numberPair.getLeft(), numberPair.getRight());
	}

	private static <T extends Number> boolean equals(Comparable<T> comparable, T number) {
		return comparable.compareTo(number) == BigDecimal.ZERO.intValue();
	}

	public static <T extends Number> boolean eq(T arg0, T arg1) {
		Pair<Long, Long> numberPair = convertLong(arg0, arg1);
		return equals(numberPair.getLeft(), numberPair.getRight());
	}

	/**
	 * 不相等 !=
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean ne(BigDecimal arg0, BigDecimal arg1) {
		return !eq(arg0, arg1);
	}

	public static <T extends Number> boolean ne(T arg0, T arg1) {
		return !eq(arg0, arg1);
	}


	/**
	 * 大于 >
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean gt(BigDecimal arg0, BigDecimal arg1) {
		Pair<BigDecimal, BigDecimal> numberPair = convertBigDecimal(arg0, arg1);
		return greaterThan(numberPair.getLeft(), numberPair.getRight());
	}

	private static <T extends Number> boolean greaterThan(Comparable<T> comparable, T number) {
		return comparable.compareTo(number) == BigDecimal.ONE.intValue();
	}

	public static <T extends Number> boolean gt(T arg0, T arg1) {
		Pair<Long, Long> numberPair = convertLong(arg0, arg1);
		return greaterThan(numberPair.getLeft(), numberPair.getRight());
	}


	/**
	 * 大于 或 等于  >=
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean gtOrEq(BigDecimal arg0, BigDecimal arg1) {

		return gt(arg0, arg1) || eq(arg0, arg1);
	}

	public static <T extends Number> boolean gtOrEq(T arg0, T arg1) {
		return gt(arg0, arg1) || eq(arg0, arg1);
	}


	/**
	 * 小于 <
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean lt(BigDecimal arg0, BigDecimal arg1) {
		Pair<BigDecimal, BigDecimal> numberPair = convertBigDecimal(arg0, arg1);

		return lessThan(numberPair.getLeft(), numberPair.getRight());
	}

	private static <T extends Number> boolean lessThan(T number, Comparable<T> comparable) {
		return comparable.compareTo(number) == BigDecimal.ONE.intValue();
	}

	public static <T extends Number> boolean lt(T arg0, T arg1) {
		Pair<Long, Long> numberPair = convertLong(arg0, arg1);
		return lessThan(numberPair.getLeft(), numberPair.getRight());
	}


	/**
	 * 小于等于 <=
	 *
	 * @param arg0 数字1
	 * @param arg1 数字2
	 * @return 返回结果
	 */
	public static boolean ltOrEq(BigDecimal arg0, BigDecimal arg1) {

		return lt(arg0, arg1) || eq(arg0, arg1);
	}

	public static <T extends Number> boolean ltOrEq(T arg0, T arg1) {

		return lt(arg0, arg1) || eq(arg0, arg1);
	}


	/**
	 * 判断指定数字是否 大于 0
	 *
	 * @param arg0 指定数字
	 * @param <T>  泛型
	 * @return 返回判断
	 */
	public static <T extends Number> boolean gtZero(T arg0) {
		return gt(arg0, BigDecimal.ZERO);
	}


	/**
	 * 判断指定数字是否 小于 0
	 *
	 * @param arg0 指定数字
	 * @param <T>  泛型
	 * @return 返回判断
	 */
	public static <T extends Number> boolean ltZero(T arg0) {
		return lt(arg0, BigDecimal.ZERO);
	}

	/**
	 * 判断指定数字是否 等于 0
	 *
	 * @param arg0 指定数字
	 * @param <T>  泛型
	 * @return 返回判断
	 */
	public static <T extends Number> boolean eqZero(T arg0) {
		return eq(arg0, BigDecimal.ZERO);
	}

	/**
	 * 判断指定数字是否 等于 0 或者小于 0
	 *
	 * @param arg0 指定数字
	 * @param <T>  泛型
	 * @return 返回判断
	 */
	public static <T extends Number> boolean ltOrEqZero(T arg0) {
		return ltZero(arg0) || eqZero(arg0);
	}

	public static void main(String[] args) {
		System.out.println(DecimalPlus.gt(1578992411196L, 1577795892547L));

		System.out.println(DecimalPlus.gt(1L, 0L));
	}


}
