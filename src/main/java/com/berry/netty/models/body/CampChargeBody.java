package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

/**
 * Created by tanhaiwen on 2015/10/29.
 */
public class CampChargeBody implements MessageBody {

    private String txntype; //交易类型 01：充值充次查询，02：充值充次确认

    private String cardno; //卡号

    private String cardcode; //卡片认证码

    private String csn; //卡片csn

    private String cardseq; //卡序列号

    private String nodenum; //充值网点编号

    private String txncount; //充值金额

    private String tac; //m1卡tac

    private String cardcount; //账户余额

    public String getCardcount() {
        return cardcount;
    }

    public void setCardcount(String cardcount) {
        this.cardcount = cardcount;
    }

    private String keyB23456; //KEYB(2,3,4,5,6)
    private String keyB789; //KEYB(7,8,9)

    private byte[] responseBody;

    public String getTxntype() {
        return txntype;
    }

    public void setTxntype(String txntype) {
        this.txntype = txntype;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCardcode() {
        return cardcode;
    }

    public void setCardcode(String cardcode) {
        this.cardcode = cardcode;
    }

    public String getCsn() {
        return csn;
    }

    public void setCsn(String csn) {
        this.csn = csn;
    }

    public String getCardseq() {
        return cardseq;
    }

    public void setCardseq(String cardseq) {
        this.cardseq = cardseq;
    }

    public String getNodenum() {
        return nodenum;
    }

    public void setNodenum(String nodenum) {
        this.nodenum = nodenum;
    }

    public String getTxncount() {
        return txncount;
    }

    public void setTxncount(String txncount) {
        this.txncount = txncount;
    }

    public String getTac() {
        return tac;
    }

    public void setTac(String tac) {
        this.tac = tac;
    }

    public String getKeyB23456() {
        return keyB23456;
    }

    public void setKeyB23456(String keyB23456) {
        this.keyB23456 = keyB23456;
    }

    public String getKeyB789() {
        return keyB789;
    }

    public void setKeyB789(String keyB789) {
        this.keyB789 = keyB789;
    }

    public byte[] getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(byte[] responseBody) {
        this.responseBody = responseBody;
    }
}
