package com.lesson.boot.jdbc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lesson.boot.jdbc.entity.Order;
import com.lesson.boot.jdbc.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author zhengshijun
 * @version created on 2020/5/28.
 */
@Slf4j
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

    public boolean exist(){

        LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Order::getId,22);
        Boolean flag = baseMapper.exist(wrapper);
        log.info("flag : {}",flag);
        return Objects.equals(flag,Boolean.TRUE);
    }

}
