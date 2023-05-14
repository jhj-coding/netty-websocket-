package com.study.websocket.demo1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 启年
 * @date 2023-05-14 13:39
 */
@Data
public class HeartbeatMessage implements Serializable {
	
	private static final long serialVersionUID = 1290124171105321491L;
	
	
	/**
	 * 发送心跳消息的用户Id
	 */
	private String userId;

}
