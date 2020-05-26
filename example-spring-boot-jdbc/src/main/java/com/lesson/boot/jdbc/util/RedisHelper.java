package com.lesson.boot.jdbc.util;

/**
 * @author zhengshijun
 * @version created on 2019/9/18.
 */
public final class RedisHelper {

	public interface Key {

		String OPEN = "'";

		String CLOSE = "'";

		String PREFIX = "testOrder:";

		String LOCK_EXP = PREFIX + "lock:handle:";

		String CACHE_EXP = PREFIX + "cache:handle:";

		String CACHE_ORDER_LIST_COUNT = CACHE_EXP + "admin:order:list:count";

		String CACHE_INVEST_LIST = CACHE_EXP + "invest:list";

		/**
		 *  lock key
		 */
		String BALANCE_FINANCE = OPEN + LOCK_EXP + "balance:financing:" + CLOSE;

		String MATCH_SUCCEED = OPEN + LOCK_EXP + "match:succeed:" + CLOSE;

		String TO_WITHDRAW = OPEN + LOCK_EXP + "to:withdraw:" + CLOSE;

		String TO_WITHDRAW_TRY = OPEN + LOCK_EXP + "to:withdraw:try:" + CLOSE;

		String PAY_SUCCEED = OPEN + LOCK_EXP + "pay:succeed:" + CLOSE;

		String INCREMENT_INCOME = OPEN + LOCK_EXP + "increment:income:" + CLOSE;

		String TO_TEST = OPEN + LOCK_EXP + "to:test:" + CLOSE;
	}


	private RedisHelper() {

	}


}
