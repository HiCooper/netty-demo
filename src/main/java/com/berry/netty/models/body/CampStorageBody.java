package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

public class CampStorageBody implements MessageBody {
	
	private String txnType; //交易类型  01：圈存查询  02：圈存确认
	private String cardNo; //卡号
	private String cardCode; //卡片认证码
	private String csn;  // 卡片CSN
	private String crdPanSeq; // 卡序列号
	private String nodeNum; // 充值网点编号
	private String cardCount; // 卡片余额
	private String txnCount; // 充值金额
	private String tac; // M1卡TAC
	
	private String authCount; //授权次数
	private String keyB23456; //KEYB(2,3,4,5,6)
	private String keyB789; //KEYB(7,8,9)
	
	private byte[]responseBody;
	
	
	public byte[] getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardCode() {
		return cardCode;
	}
	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}
	public String getCsn() {
		return csn;
	}
	public void setCsn(String csn) {
		this.csn = csn;
	}
	public String getCrdPanSeq() {
		return crdPanSeq;
	}
	public void setCrdPanSeq(String crdPanSeq) {
		this.crdPanSeq = crdPanSeq;
	}
	public String getNodeNum() {
		return nodeNum;
	}
	public void setNodeNum(String nodeNum) {
		this.nodeNum = nodeNum;
	}
	public String getCardCount() {
		return cardCount;
	}
	public void setCardCount(String cardCount) {
		this.cardCount = cardCount;
	}
	public String getTxnCount() {
		return txnCount;
	}
	public void setTxnCount(String txnCount) {
		this.txnCount = txnCount;
	}
	public String getTac() {
		return tac;
	}
	public void setTac(String tac) {
		this.tac = tac;
	}
	public String getAuthCount() {
		return authCount;
	}
	public void setAuthCount(String authCount) {
		this.authCount = authCount;
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
	
}
