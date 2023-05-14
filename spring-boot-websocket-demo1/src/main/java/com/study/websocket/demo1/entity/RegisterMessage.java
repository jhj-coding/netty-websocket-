package com.study.websocket.demo1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 启年
 * @date 2023-05-14 13:40
 */
@Data
public class RegisterMessage implements Serializable {
	
	private static final long serialVersionUID = -4953615574208683170L;
	/**
	 * 注册到服务端的用户Id
	 */
	private String userId;
}
