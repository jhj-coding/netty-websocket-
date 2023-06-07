package com.study.websocket.demo1.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 启年
 * @date 2023-05-12 22:55
 */
@Slf4j
@AllArgsConstructor
public class WebSocketServerInitializer extends ChannelInitializer<NioSocketChannel> {
	
	/**
	 * WebSocket 服务的接口地址
	 */
	public String webSocketPath;
	
	@Override
	protected void initChannel(NioSocketChannel ch) throws Exception {
		log.debug("服务的接口地址：{}", webSocketPath);
		ChannelPipeline pipeline = ch.pipeline();
		//自定义的Handler-心跳检测
		pipeline.addLast(new WebSocketIdleStateHandler());
		//HTTP协议编解码器，用于处理HTTP请求和响应的编码和解码。其主要作用是将HTTP请求和响应消息转换为Netty的ByteBuf对象，并将其传递到下一个处理器进行处理。
		pipeline.addLast(new HttpServerCodec());
		//用于HTTP服务端，将来自客户端的HTTP请求和响应消息聚合成一个完整的消息，以便后续的处理。
		pipeline.addLast(new HttpObjectAggregator(65536));
		//用于对WebSocket消息进行压缩和解压缩操作。
		pipeline.addLast(new WebSocketServerCompressionHandler());
		//可以对整个WebSocker通信进行初始化（当Http请求中有升级为WebSocker的请求时），以及握手处理
		pipeline.addLast(new WebSocketServerProtocolHandler(webSocketPath, null, true));
		//自定义的Handler-处理WebSocket文本类型的消息
		pipeline.addLast(new WebSocketTextHandler());
	}
	
}
