package com.study.websocket.demo1.handler;

import com.study.websocket.demo1.config.NettyConfig;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrameDecoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
		pipeline.addLast(new WebSocketIdleStateHandler());
		pipeline.addLast(new HttpServerCodec());
		pipeline.addLast(new HttpObjectAggregator(65536));
		pipeline.addLast(new WebSocketServerCompressionHandler());
		pipeline.addLast(new WebSocketServerProtocolHandler(webSocketPath,"WebSocket",true,65536 * 10));
		pipeline.addLast(new WebSocketTextHandler());
	}
	
}
