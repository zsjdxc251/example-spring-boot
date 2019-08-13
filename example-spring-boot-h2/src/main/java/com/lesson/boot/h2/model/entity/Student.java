package com.lesson.boot.h2.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhengshijun
 * @version created on 2019/8/13.
 */
@Data
@TableName(value = "student",schema = "h2_sample")
public class Student {

    private Long studentId;

    private String studentName;

    private Byte gender;

    private Integer age;


}
