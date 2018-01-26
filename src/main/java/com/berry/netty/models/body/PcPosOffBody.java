package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

public class PcPosOffBody implements MessageBody {
	
	private String batchDate;
	//数据总数
	private String count;
	//参数索引
	private String paraIndex;
	//清算时间
	private String clearDate;
	//是否有后续
	private boolean isOver;
	
	private byte[] responseBody ; 
	
	public String getBatchDate() {
		return batchDate;
	}
	public void setBatchDate(String batchDate) {
		this.batchDate = batchDate;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getParaIndex() {
		return paraIndex;
	}
	public void setParaIndex(String paraIndex) {
		this.paraIndex = paraIndex;
	}
	public byte[] getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(byte[] responseBody) {
		this.responseBody = responseBody;
	}
	public boolean getIsOver() {
		return isOver;
	}
	public void setIsOver(boolean isOver) {
		this.isOver = isOver;
	}
	public String getClearDate() {
		return clearDate;
	}
	public void setClearDate(String clearDate) {
		this.clearDate = clearDate;
	}
	
}
