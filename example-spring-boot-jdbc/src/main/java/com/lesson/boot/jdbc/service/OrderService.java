package com.lesson.boot.jdbc.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lesson.boot.jdbc.entity.Order;
import com.lesson.boot.jdbc.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhengshijun
 * @version created on 2020/5/28.
 */
@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    private WithdrawService withdrawService;

    @Transactional(rollbackFor = Exception.class)
    public Long saveRetId(String name){

        Order order = new Order();
        order.setName(name);
        save(order);
        Long id = withdrawService.saveRetId(order.getId());
        return id;
    }

}
