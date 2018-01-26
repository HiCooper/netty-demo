package com.berry.netty.models;


import lombok.Data;

import java.io.Serializable;

/**
 * @author Berry_Cooper
 * @date 2018/1/22.
 */

@Data
public class MessageNetty implements Serializable {

    /**
     * 消息包的长度
     */
    private int messageLength;

    /**
     * 完整消息包
     */
    private byte[] messageBody;

    /**
     * 消息包的对端ip
     */
    private String remoteAddress;


    /**
     * TPDU 头(TPDU-传送协议数据单元)
     */
    private byte[] tpdu;

    /**
     * TPDU 头长度
     */
    private int tpduLength;

    /**
     * 请求响应类型
     */
    private Boolean type;
}
