package com.berry.netty.models.body;

public class VoiceFileBody {
	
	private String fileName; // 文件名称
	
	private String fileSize; // 文件大小

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

}
