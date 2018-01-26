package com.berry.netty.models.body;


/**
 * 参数下载 - 白名单下载
 */
public class WhiteListBody {


	private String cardLen; //长度
	
	private String cardNo;  //卡号
	
	public String getCardLen() {
		return cardLen;
	}

	public void setCardLen(String cardLen) {
		this.cardLen = cardLen;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

}
