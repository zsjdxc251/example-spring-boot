package com.lesson.boot.jdbc.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lesson.boot.jdbc.entity.Withdraw;
import com.lesson.boot.jdbc.mapper.WithdrawMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhengshijun
 * @version created on 2020/5/28.
 */
@Service
public class WithdrawService extends ServiceImpl<WithdrawMapper, Withdraw> {


    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public Long saveRetId(Long orderId){
        Withdraw withdraw =  new Withdraw();
        withdraw.setOrderId(orderId);
        save(withdraw);
        return withdraw.getId();
    }

}
