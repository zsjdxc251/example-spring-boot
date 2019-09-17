package com.lesson.boot.cache.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhengshijun
 * @version created on 2019/9/16.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {

	private Long id;

	private String username;

	private String password;

}
