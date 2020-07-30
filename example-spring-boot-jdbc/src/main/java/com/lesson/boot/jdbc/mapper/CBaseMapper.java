package com.lesson.boot.jdbc.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhengshijun
 * @version created on 2020/7/30.
 */
public interface CBaseMapper<T> extends BaseMapper<T> {


    default boolean exist(@Param("ew") Wrapper<T> wrapper) {


        return false;
    }
}
