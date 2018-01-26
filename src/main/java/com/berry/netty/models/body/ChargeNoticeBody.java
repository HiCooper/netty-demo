package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

public class ChargeNoticeBody implements MessageBody {
	
	private String key23456; // M1卡2,3,4,5,6扇区KEY

	private String key789; // M1卡7,8,9扇区KEYB

	public String getKey23456() {
		return key23456;
	}

	public void setKey23456(String key23456) {
		this.key23456 = key23456;
	}

	public String getKey789() {
		return key789;
	}

	public void setKey789(String key789) {
		this.key789 = key789;
	}

}
