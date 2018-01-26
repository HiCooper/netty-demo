package com.berry.netty;

import com.berry.netty.config.GlobalProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NettyImDemoApplicationTests {

    @Autowired
    private GlobalProperties globalProperties;


    @Test
    public void contextLoads() {
        int port = this.globalProperties.getPort();
        System.out.println(port);
    }

}
