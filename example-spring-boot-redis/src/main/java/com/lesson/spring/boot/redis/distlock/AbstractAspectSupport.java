package com.lesson.spring.boot.redis.distlock;

import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.expression.AnnotatedElementKey;
import org.springframework.context.expression.MethodBasedEvaluationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * {@link CacheAspectSupport}
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
public abstract class AbstractAspectSupport {

	private final ExpressionParser parser = new SpelExpressionParser();
	private final ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
	private final Map<ExpressionKey, Expression> keyCache = new ConcurrentHashMap<>(64);
	/**
	 * 生成 动态的数据
	 *
	 * @param metadata 数据
	 * @return 返回KEY
	 */
	@SuppressWarnings("unchecked")
	protected <T> T format(OperationMetadata metadata) {
		EvaluationContext evaluationContext = createEvaluationContext(metadata.getMethod(), metadata.getArgs(), metadata.getTarget(), metadata.getTargetClass());
		Object result = getExpression(metadata.getExpression(), metadata.getMethodKey()).getValue(evaluationContext);
		return (T) result;
	}

	private Expression getExpression(String expression, AnnotatedElementKey elementKey) {

		ExpressionKey expressionKey = createKey(elementKey, expression);
		Expression expr = keyCache.get(expressionKey);
		if (expr == null) {
			expr = parser.parseExpression(expression);
			keyCache.put(expressionKey, expr);
		}
		return expr;
	}

	private EvaluationContext createEvaluationContext(Method method, Object[] arguments, Object target, Class<?> targetClass) {

		GeneralExpressionRootObject rootObject = new GeneralExpressionRootObject(method, arguments, target, targetClass);
		return new MethodBasedEvaluationContext(rootObject, method, arguments, parameterNameDiscoverer);

	}


	private ExpressionKey createKey(AnnotatedElementKey elementKey, String expression) {
		return new ExpressionKey(elementKey, expression);
	}

	protected static class ExpressionKey implements Comparable<ExpressionKey> {

		private final AnnotatedElementKey element;

		private final String expression;

		private ExpressionKey(AnnotatedElementKey element, String expression) {
			Assert.notNull(element, "AnnotatedElementKey must not be null");
			Assert.notNull(expression, "Expression must not be null");
			this.element = element;
			this.expression = expression;
		}

		@Override
		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof ExpressionKey)) {
				return false;
			}
			ExpressionKey otherKey = (ExpressionKey) other;
			return (this.element.equals(otherKey.element) &&
					ObjectUtils.nullSafeEquals(this.expression, otherKey.expression));
		}

		@Override
		public int hashCode() {
			return this.element.hashCode() * 29 + this.expression.hashCode();
		}

		@Override
		public String toString() {
			return this.element + " with expression \"" + this.expression + "\"";
		}

		@Override
		public int compareTo(ExpressionKey other) {
			int result = this.element.toString().compareTo(other.element.toString());
			if (result == 0) {
				result = this.expression.compareTo(other.expression);
			}
			return result;
		}
	}

}
