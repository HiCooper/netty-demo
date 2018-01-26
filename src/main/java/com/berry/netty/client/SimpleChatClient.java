package com.berry.netty.client;

import com.berry.netty.commons.utils.JsonUtils;
import com.berry.netty.models.MessageNetty;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.stereotype.Service;




/**
 * IM-Client
 *
 * @author Berry_Cooepr
 */
@Service
public class SimpleChatClient {


    public static void createConnection(MessageNetty messageNetty) {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());
            Channel channel = bootstrap.connect("localhost", 8379).sync().channel();
            String serializerMsg = JsonUtils.toJson(messageNetty);
            int i = 0;
            while (true) {
                if (i == 10) {
                    break;
                }
                Thread.sleep(1000);
                channel.writeAndFlush(serializerMsg + "$_");
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }


}
