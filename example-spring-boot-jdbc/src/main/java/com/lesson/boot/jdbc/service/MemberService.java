package com.lesson.boot.jdbc.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lesson.boot.jdbc.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionSynchronizationUtils;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhengshijun
 * @version created on 2020/6/2.
 */
@Service
public class MemberService {


	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private OrderService orderService;

	@Autowired
	private DataSource dataSource;


	public void add(){

		final Connection connection = DataSourceUtils.getConnection(dataSource);

		System.out.println(connection);
		try {
			System.out.println(connection.isReadOnly());
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		transactionTemplate.executeWithoutResult(transactionStatus -> {
			// 没有结果返回的
		});

		TransactionStatus status1 = transactionTemplate.execute(status -> {

//			Connection connection1 = DataSourceUtils.getConnection(dataSource);
//
//			System.out.println(connection1);
//			try {
//				System.out.println(connection1.isReadOnly());
//			} catch (SQLException throwables) {
//				throwables.printStackTrace();
//			}
//			LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
//			System.out.println(orderService.getMap(wrapper));
			System.out.println(status.hasSavepoint());
			Object o = status.createSavepoint();
			orderService.saveRetId("试一下数据44466777");

			System.out.println(status.isNewTransaction());
			System.out.println(status.hasSavepoint());
			System.out.println(status.isCompleted());
			System.out.println(status.isRollbackOnly());
			System.out.println(status.isCompleted());
			status.releaseSavepoint(o);
			status.flush();
			System.out.println(status.isCompleted());
			//throw new RuntimeException();
//			/status.rollbackToSavepoint(o);

			//return "";
			return status;

		});

		System.out.println(status1.isCompleted());
	}

}
