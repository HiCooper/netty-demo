package com.berry.netty.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Berry_Cooper
 * @date 2018/1/22.
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "global")
public class GlobalProperties {

    private int port;

}
