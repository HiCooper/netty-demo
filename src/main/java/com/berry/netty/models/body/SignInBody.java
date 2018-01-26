package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

/**
 * 签到
 * @author 
 *
 */
public class SignInBody implements MessageBody {
	//终端工作密钥
	private String termKey;
	 
	public String getTermKey() {
		return termKey;
	}

	public void setTermKey(String termKey) {
		this.termKey = termKey;
	}
	
}
