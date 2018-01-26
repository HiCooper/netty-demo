package com.berry.netty.client;

import com.berry.netty.filter.NettyDecoder;
import com.berry.netty.filter.NettyEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;


/**
 * Client ChannelInitializer
 *
 * @author Berry_Cooper
 */
public class SimpleChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, buf));
        pipeline.addLast("decoder", new NettyDecoder());
        pipeline.addLast("encoder", new NettyEncoder());
        pipeline.addLast("handler", new SimpleChatClientHandler());
    }
}
