package com.study.websocket.demo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 启年
 * @date 2023-05-13 12:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	
	private static final long serialVersionUID = 3147392908880170895L;
	
	/**
	 * 用户Id
	 */
	private String userId;
	
	/**
	 * 用户名
	 */
	private String username;
	
}
