package com.berry.netty.models;

import lombok.Data;

/**
 * 报文实体类头部
 *
 * @author 西
 */
@Data
public class MessageHeader {

    /**
     * 版本号
     **/
    private String msgVersion;

    /**
     * 报文加密标志
     **/
    private String msgEnc;

    /**
     * 渠道系统编号
     **/
    private String clientId;

    /**
     * 交易类型
     **/
    private String msgType;

    /**
     * 发送日期时间
     **/
    private String msgTime;

    /**
     * 商户号
     **/
    private String merchantId;

    /**
     * 终端号
     **/
    private String temId;

    /**
     * 批次号
     **/
    private String batchNum;

    /**
     * 终端流水号
     **/
    private String posSeqNum;

    /**
     * 应答码
     **/
    private String respCode;

    /**
     * 系统日期时间
     **/
    private String sysTime;

    /**
     * 系统流水号
     **/
    private String sysTxnId;

    /**
     * 后续报文标识
     **/
    private String follow;

    /**
     * MAC校验码
     */
    private String mac;

    /**
     * 消息内容体 除去报文以上参数
     */
    private MessageBody  messageBody;

}
