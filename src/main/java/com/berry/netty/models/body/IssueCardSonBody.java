package com.berry.netty.models.body;


/**
 * 二次发卡交易 返回 子报文 
 * @author rain
 *
 */

public class IssueCardSonBody {
	
    private long blocknum;  //块号
	
	private String blockdata;  //块数据

	public long getBlocknum() {
		return blocknum;
	}

	public void setBlocknum(long blocknum) {
		this.blocknum = blocknum;
	}

	public String getBlockdata() {
		return blockdata;
	}

	public void setBlockdata(String blockdata) {
		this.blockdata = blockdata;
	}
	
	
}
