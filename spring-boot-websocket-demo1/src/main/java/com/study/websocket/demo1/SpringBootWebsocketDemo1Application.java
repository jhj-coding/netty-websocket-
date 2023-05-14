package com.study.websocket.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.study.websocket")
public class SpringBootWebsocketDemo1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebsocketDemo1Application.class, args);
	}
	
}
