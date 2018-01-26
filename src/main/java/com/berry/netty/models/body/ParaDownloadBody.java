package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

import java.util.List;

/**
 * 参数下载
 * @author  xx 
 *
 */
public class ParaDownloadBody implements MessageBody {
    /**
     * 主密钥
     */
	private String paraType;//参数类型  (00-POS主密钥，01-卡黑名单,02-卡BIN表03-终端程序(TMS)06-AID,07-CAPK)
	
	private String paraIndex;//参数索引
	
	private Integer paraLenth;//参数长度
	
	private String tmk; //终端主密钥
	
	private String tmks; //报文主密钥
	
	 /**
     * 黑名单
     */
	
	private List<BlackCardBody> blackList ;

	private List<WhiteListBody> whiteList ; //黑名单的反义词
	
	private String version; //版本
	
    /**
     * 卡bin
     */
    private List<CardBinBody>   cardBinList;
    
    private List<VoiceFileBody> fileInfoList; // 文件
    
    public List<VoiceFileBody> getFileInfoList() {
		return fileInfoList;
	}

	public void setFileInfoList(List<VoiceFileBody> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	/**
     * 终端程序(TMS)
     */
	private String fileName; //文件名
	
	private String fileSize; //文件大小
	
	private String currSize; //当前大小
	
	private byte[] fileData; //文件数据
	
	private String Recdata; // 接收文件数据

	public String getRecdata() {
		return Recdata;
	}

	public void setRecdata(String recdata) {
		Recdata = recdata;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getCurrSize() {
		return currSize;
	}

	public void setCurrSize(String currSize) {
		this.currSize = currSize;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

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


	public String getTmk() {
		return tmk;
	}

	public void setTmk(String tmk) {
		this.tmk = tmk;
	}

	public String getTmks() {
		return tmks;
	}

	public void setTmks(String tmks) {
		this.tmks = tmks;
	}

	public Integer getParaLenth() {
		return paraLenth;
	}

	public void setParaLenth(Integer paraLenth) {
		this.paraLenth = paraLenth;
	}

	public List<BlackCardBody> getBlackList() {
		return blackList;
	}

	public void setBlackList(List<BlackCardBody> blackList) {
		this.blackList = blackList;
	}

	public List<CardBinBody> getCardBinList() {
		return cardBinList;
	}

	public void setCardBinList(List<CardBinBody> cardBinList) {
		this.cardBinList = cardBinList;
	}

	public List<WhiteListBody> getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(List<WhiteListBody> whiteList) {
		this.whiteList = whiteList;
	}
}
