package com.lesson.boot.sharding.service;

import com.lesson.boot.sharding.entity.Order;
import com.lesson.boot.sharding.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhengshijun
 * @version created on 2020/8/7.
 */
@Service
public class OrderService {

	@Autowired
	private OrderMapper orderMapper;

	@Transactional(rollbackFor = Exception.class)
	public void select(){

		Order order = orderMapper.selectById(264544L);

		orderMapper.insert(order);
	}
}
