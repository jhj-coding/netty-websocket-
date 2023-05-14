package com.study.websocket.demo1.controller;

import com.study.websocket.demo1.service.ISendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 启年
 * @date 2023-05-12 23:33
 */
@RestController
@RequestMapping("/send")
public class SendMsgController {
	
	@Autowired
	private ISendMessageService sendMessageService;
	
	/**
	 * 单发消息：根据UserId给某个用户发送消息
	 */
	@PostMapping("/user")
	public Map<String, Object> sendMsgToUserByUserId(
			@RequestParam("userId") String userId,
			@RequestParam("receiver") String receiver,
			@RequestParam("msg") String msg) {
		sendMessageService.sendMsgToUserByUserId(userId, receiver,msg);
		Map<String, Object> response = new HashMap<>();
		response.put("code", HttpServletResponse.SC_OK);
		response.put("msg", "给" + userId + "的消息发送成功");
		return response;
	}
	
	/**
	 * 群发消息：给所有在线的客户端发送消息
	 */
	@PostMapping("/group")
	public Map<String, Object> sendMsgToGroup(@RequestParam("msg") String msg) {
		sendMessageService.sendMsgToGroup(msg);
		Map<String, Object> response = new HashMap<>();
		response.put("code", HttpServletResponse.SC_OK);
		response.put("msg", "群发消息成功");
		return response;
	}
	
}
