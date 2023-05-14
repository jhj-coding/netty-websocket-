package com.study.websocket.demo1.enums;

/**
 * @author 启年
 * @date 2023-05-14 13:36
 */
public enum MessageTypeEnum {
	TEXT("普通文本消息"),
	HEARTBEAT("心跳数据"),
	REGISTER("注册数据");
	
	MessageTypeEnum() {
	}
	
	MessageTypeEnum(String desc) {
	}
}
