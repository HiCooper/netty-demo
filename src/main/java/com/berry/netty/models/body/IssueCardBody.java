package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

/**
 * 二次发卡
 * @author rain
 *
 */

public class IssueCardBody implements MessageBody {
	
	private String txntype;  //交易类型
	
	private String cardno;  //卡号
	
	private String cardcode;  //卡片认证码
	
	private String csn;  //卡片CSN
	
	private String crdpanseq;  //卡序列号
	
	private String nodenum;  //开卡机构
	
	private String authcount;  //授权次数
	
	private Long accountbal; // 账户余额
	
	private byte[] responseBody; //返回的报文体
	
	
	public Long getAccountbal() {
		return accountbal;
	}

	public void setAccountbal(Long accountbal) {
		this.accountbal = accountbal;
	}

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

	public String getCrdpanseq() {
		return crdpanseq;
	}

	public void setCrdpanseq(String crdpanseq) {
		this.crdpanseq = crdpanseq;
	}

	public String getNodenum() {
		return nodenum;
	}

	public void setNodenum(String nodenum) {
		this.nodenum = nodenum;
	}

	public String getAuthcount() {
		return authcount;
	}

	public void setAuthcount(String authcount) {
		this.authcount = authcount;
	}

	public byte[] getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}

}
