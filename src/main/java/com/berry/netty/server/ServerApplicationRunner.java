package com.berry.netty.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Berry_Cooper
 * @date 2018/1/16.
 */
@Component
public class ServerApplicationRunner implements ApplicationRunner {

    @Autowired
    private SimpleChatServer simpleChatServer;

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        simpleChatServer.run();
    }
}
