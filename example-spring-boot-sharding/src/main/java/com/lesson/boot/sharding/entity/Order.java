package com.lesson.boot.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author zhengshijun
 * @version created on 2020/8/7.
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_purchase_order")
public class Order {
	private static final long serialVersionUID = 8025925345765570181L;

	@TableId
	private Long id;

	private Long uid;

	private Long productId;

	private BigDecimal rate;

	private BigDecimal amount;

	private Integer status;

	private Long createTime;

	private Long finishTime;

	private BigDecimal totalIncome;

	private Long endTime;

	private BigDecimal expectIncome;

	private String name;

	private Long fromId;

	private Long couponId;

	private BigDecimal investmentAmount;

	private BigDecimal principal;

	private Long rmId;

	private Long payTime;

	private Integer type;

	/**
	 * 额外利息
	 */
	private BigDecimal extraInterest;

	/**
	 * 最后修改时间
	 */
	private Long updateTime;

	/**
	 * 部分撮合成功的订单，拆分子订单，订单Id
	 */
	private Long parentId;

	/**
	 * 开始计息当天
	 */
	private Long startTime;

	/**
	 * 订单号
	 */
	private String orderNo;

	/**
	 * 支付ID
	 */
	private Long payId;

	/**
	 *  是否是自动续投
	 *  0 否 1 是
	 */
	private Integer autoContinue;

	/**
	 * 自动续投触发事件
	 */
	private Long autoMfyTime;

	/**
	 * 扣除金额
	 */
	@Deprecated
	private BigDecimal deductAmount;

	/**
	 * 数据来源
	 */
	private Integer origin;
}
