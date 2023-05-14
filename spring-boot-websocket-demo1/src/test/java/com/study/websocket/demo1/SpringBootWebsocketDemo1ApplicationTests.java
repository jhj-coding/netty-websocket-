package com.study.websocket.demo1;

import com.alibaba.fastjson.JSON;
import com.study.websocket.demo1.enums.MessageTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootWebsocketDemo1ApplicationTests {
	
	@Test
	void contextLoads() {
	
	
	}
	
	public static void main(String[] args) {
		String json = JSON.toJSONString(MessageTypeEnum.TEXT);
		//MessageTypeEnum messageTypeEnum1 = MessageTypeEnum.valueOf("text");
		MessageTypeEnum messageTypeEnum2 = MessageTypeEnum.valueOf("TEXT");
		//MessageTypeEnum messageTypeEnum = JSON.parseObject(json, );
		//System.out.println(messageTypeEnum1);
		System.out.println(messageTypeEnum2);
	}
}
