package com.lesson.spring.boot.properties.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhengshijun
 * @version created on 2018/12/22.
 */
@Getter
@Setter
public  class SingledataProperties extends AbstractProperties {

    private String username;

    private Integer age;

    private String name;
}
