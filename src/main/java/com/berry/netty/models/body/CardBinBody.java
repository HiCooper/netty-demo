package com.berry.netty.models.body;


import com.berry.netty.models.MessageBody;

/**
 * 参数下载 - 卡bin下载
 */
public class CardBinBody implements MessageBody {
	
	private String cardLen; //长度
	
	private String cardBin; //卡bin

	public String getCardLen() {
		return cardLen;
	}

	public void setCardLen(String cardLen) {
		this.cardLen = cardLen;
	}

	public String getCardBin() {
		return cardBin;
	}

	public void setCardBin(String cardBin) {
		this.cardBin = cardBin;
	}
	
	

}
