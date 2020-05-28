package com.lesson.boot.jdbc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhengshijun
 * @version created on 2020/5/28.
 */
@Data
@TableName("t_withdraw")
public class Withdraw {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long orderId;
}
