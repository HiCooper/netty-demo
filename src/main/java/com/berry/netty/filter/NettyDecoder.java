package com.berry.netty.filter;

import com.berry.netty.commons.parse.MessageParse;
import com.berry.netty.commons.utils.ConvertTools;
import com.berry.netty.models.MessageNetty;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author Berry_Cooper
 * @date 2018/1/23.
 */
@ChannelHandler.Sharable
public class NettyDecoder extends MessageToMessageDecoder<ByteBuf> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        logger.info("********************* 拆包 *********************");
        //1.将16进制字符串转为可阅读的ASCII字符
        String message = ConvertTools.convertHexToASCIIString(msg.toString(Charset.defaultCharset()));
        //2.解析报文
        Channel channel = ctx.channel();
        MessageNetty messageNetty = MessageParse.parseMessage(channel, message);
        out.add(messageNetty);
    }
}
