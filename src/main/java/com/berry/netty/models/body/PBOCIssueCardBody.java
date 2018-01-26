package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

/**
 * pboc 二次发卡
 * @author Administrator
 *
 */
public class PBOCIssueCardBody implements MessageBody {
	
	private String txntype;  //交易类型
	
	private String version;  //版本
	
	private String bankid;  //银行编号
	
	private String appindex;  //应用索引
	
	private String sfi;  //短文件表示符
	
	private String recordnumber;  //记录号
	
	private String pan;  //卡号
	
	private String panid;  //卡序列号
	
	private String csn;  //卡片唯一序列号
	
	private String atc;  //交易计数器
	
	private String appopenkeyidx;  //行业应用开通密钥索引
	
	private String appmgrkeyidx;  //行业应用管理密钥索引
	
	private String follow;  //后续字节保留
	
	private String cardcount; //卡片余额
	
	public String getCardcount() {
		return cardcount;
	}

	public void setCardcount(String cardcount) {
		this.cardcount = cardcount;
	}

	private byte[] response; //返回报文
	
	

	public byte[] getResponse() {
		return response;
	}

	public void setResponse(byte[] response) {
		this.response = response;
	}

	public String getTxntype() {
		return txntype;
	}

	public void setTxntype(String txntype) {
		this.txntype = txntype;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getAppindex() {
		return appindex;
	}

	public void setAppindex(String appindex) {
		this.appindex = appindex;
	}

	public String getSfi() {
		return sfi;
	}

	public void setSfi(String sfi) {
		this.sfi = sfi;
	}

	public String getRecordnumber() {
		return recordnumber;
	}

	public void setRecordnumber(String recordnumber) {
		this.recordnumber = recordnumber;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getPanid() {
		return panid;
	}

	public void setPanid(String panid) {
		this.panid = panid;
	}

	public String getCsn() {
		return csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public String getAtc() {
		return atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public String getAppopenkeyidx() {
		return appopenkeyidx;
	}

	public void setAppopenkeyidx(String appopenkeyidx) {
		this.appopenkeyidx = appopenkeyidx;
	}

	public String getAppmgrkeyidx() {
		return appmgrkeyidx;
	}

	public void setAppmgrkeyidx(String appmgrkeyidx) {
		this.appmgrkeyidx = appmgrkeyidx;
	}

	public String getFollow() {
		return follow;
	}

	public void setFollow(String follow) {
		this.follow = follow;
	}

	

}
