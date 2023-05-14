package com.study.websocket.demo1.controller;

import com.study.websocket.demo1.config.NettyConfig;
import com.study.websocket.demo1.entity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 启年
 * @date 2023-05-13 12:45
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	/**
	 * 返回在线的UserId
	 */
	@CrossOrigin(originPatterns = {"http://localhost:8081","http://sso.server.com:9999","http://10.40.129.179:8081"})
	@GetMapping("/online/list")
	public Map<String, Object> onlineList() {
		Map<String, Object> response = new HashMap<>();
		
		List<User> list = new ArrayList<>();
		NettyConfig.getOnlineUserChannelMap().forEach((key, value) -> {
			User user = new User(key, key);
			list.add(user);
		});
		response.put("code", 200);
		response.put("msg", "success");
		response.put("data", list);
		return response;
	}
	
}
