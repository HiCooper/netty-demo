package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

@Data
public class BusChargeBody implements MessageBody {
    /**
     * 交易类型 : 01:充值冲次查询 02:充值冲次确认
     */
    private String txnType;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 卡片认证码
     */
    private String cardCode;
    /**
     * 卡片CSN
     */
    private String csn;

    /**
     * 卡序列号
     */
    private String cardSeq;
    /**
     * 充值网点编号
     */
    private String nodeNum;
    /**
     * 卡片余次
     */
    private String cardCount;
    /**
     * 冲次次数
     */
    private String txnCount;

    /**
     * M1卡TAC
     */
    private String tac;

    /**
     * 授权次数
     */
    private String authCount;
    /**
     * M1卡2,3,4,5,6扇区KEY
     */
    private String key23456;
    /**
     * M1卡7,8,9扇区KEYB
     */
    private String key789;
    /**
     * 年检日期
     */
    private String crdYearTime;

    private byte[] body;
}
