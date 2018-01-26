package com.berry.netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Client channel handler
 *
 * @author Berry_Cooper
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) throws Exception {
        //just print the msg
        System.out.println("客户端收到服务端返回消息：" + msg);
    }
}
