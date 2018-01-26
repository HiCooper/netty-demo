package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

/**
 * 园区参数下载
 * @author rain
 *
 */
public class CampParaDownBody  implements MessageBody {

	/*
	 * 请求报文
	 */
	private String paraType;//参数类型  :01 -园区优惠策略
	
	private String paraIndex; //参数索引
	
	
	private String paraLen; //参数总长度
	
	private String paraData; //参数数据
	
	private String ruleNum; //策略数量
	
	private String ruleType; //策略类型
	
	private String ruleAmt;  //策略金额（分）/百分比（%）
	
	private String cardBinLen; //卡BIN长度
	
	private String cardBin; //卡bin
	
	private String ruleTime; //优惠时段

	public String getParaType() {
		return paraType;
	}

	public void setParaType(String paraType) {
		this.paraType = paraType;
	}

	public String getParaIndex() {
		return paraIndex;
	}

	public void setParaIndex(String paraIndex) {
		this.paraIndex = paraIndex;
	}

	public String getParaLen() {
		return paraLen;
	}

	public void setParaLen(String paraLen) {
		this.paraLen = paraLen;
	}

	public String getRuleNum() {
		return ruleNum;
	}

	public void setRuleNum(String ruleNum) {
		this.ruleNum = ruleNum;
	}

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public String getRuleAmt() {
		return ruleAmt;
	}

	public void setRuleAmt(String ruleAmt) {
		this.ruleAmt = ruleAmt;
	}

	public String getCardBinLen() {
		return cardBinLen;
	}

	public void setCardBinLen(String cardBinLen) {
		this.cardBinLen = cardBinLen;
	}

	public String getCardBin() {
		return cardBin;
	}

	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}

	public String getRuleTime() {
		return ruleTime;
	}

	public void setRuleTime(String ruleTime) {
		this.ruleTime = ruleTime;
	}

	public String getParaData() {
		return paraData;
	}

	public void setParaData(String paraData) {
		this.paraData = paraData;
	}
	
	
}
