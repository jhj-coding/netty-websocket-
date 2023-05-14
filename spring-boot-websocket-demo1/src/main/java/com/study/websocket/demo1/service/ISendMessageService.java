package com.study.websocket.demo1.service;

/**
 * @author 启年
 * @date 2023-05-12
 */
public interface ISendMessageService {
	
	/**
	 * 根据 UserId 将信息发送给指定的用户
	 *
	 * @param userId   发送消息的用户Id
	 * @param receiver 接收消息的用户Id
	 * @param msg      要发送的消息
	 */
	void sendMsgToUserByUserId(String userId, String receiver, String msg);
	
	/**
	 * 给所有的在线用户发送消息
	 *
	 * @param msg 要发送的消息
	 */
	void sendMsgToGroup(String msg);
	
}
