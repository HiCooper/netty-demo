package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;

public class DataRecordsBody implements MessageBody {

	private String recordlen;// 记录长度

	private String collectid;// 采集点编号

	private String busid;// 车辆编号

	private String linecode;// 线路代码

	private String mchtid;// 商户号

	private String termid;// 终端号

	private String citycode;// 城市代码

	private String busiid;// 业务类型编码

	private String befbal;// 交易前卡片余额

	private String oritxnamt;// 原交易金额

	private String txnamt;// 交易金额

	private String txndatetime;// 交易日期时间

	private String txnseq;// 交易POS流水号

	private String cardno;// 卡号

	private String csn;// 卡片CSN

	private String cardkind;// 卡种类型

	private String cardmodel;// 卡物理类型

	private String checkcard;// 司机卡号

	private String checktime;// 司机刷卡时间

	private String samid;// PSAM卡号

	private String upstationid;// 上车站点

	private String downstationid;// 下车站点

	private String reserved;// 保留域
	
	private String accouttype;//消费标识  00扣次 01扣钱

	private String tac;// M1TAC

	private String cardseq;// 卡片序号

	private String cardenddt;// 卡有效期

	private String cardappenddt;// 卡应用有效期

	private String aid;// 应用编号

	private String ac;// 应用密文

	private String tvm;// 终端性能

	private String tvr;// 终端验证结果

	private String rand;// 不可预知数

	private String ifd;// 接口设备序列号

	private String appdata;// 发卡行应用数据

	private String atc;// 应用交易计数器

	private String aip;// 应用交互特征

	private String trandt;// 交易日期

	private String txnrsp;// 交易响应码

	private String trantp;// 交易类型

	private String statecode;// 终端国家代码

	private String amtcode;// 交易货币代码

	private String cptinfo;// 密文信息数据

	private String otheramt;// 其他金额

	private String cvmr;// 持卡人验证方法结果

	private String termtp;// 终端类型

	private String df;// 专用文件名

	public String getRecordlen() {
		return recordlen;
	}

	public void setRecordlen(String recordlen) {
		this.recordlen = recordlen;
	}

	public String getCollectid() {
		return collectid;
	}

	public void setCollectid(String collectid) {
		this.collectid = collectid;
	}

	public String getBusid() {
		return busid;
	}

	public void setBusid(String busid) {
		this.busid = busid;
	}

	public String getLinecode() {
		return linecode;
	}

	public void setLinecode(String linecode) {
		this.linecode = linecode;
	}

	public String getMchtid() {
		return mchtid;
	}

	public void setMchtid(String mchtid) {
		this.mchtid = mchtid;
	}

	public String getTermid() {
		return termid;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getBusiid() {
		return busiid;
	}

	public void setBusiid(String busiid) {
		this.busiid = busiid;
	}

	public String getBefbal() {
		return befbal;
	}

	public void setBefbal(String befbal) {
		this.befbal = befbal;
	}

	public String getOritxnamt() {
		return oritxnamt;
	}

	public void setOritxnamt(String oritxnamt) {
		this.oritxnamt = oritxnamt;
	}

	public String getTxnamt() {
		return txnamt;
	}

	public void setTxnamt(String txnamt) {
		this.txnamt = txnamt;
	}

	public String getTxndatetime() {
		return txndatetime;
	}

	public void setTxndatetime(String txndatetime) {
		this.txndatetime = txndatetime;
	}

	public String getTxnseq() {
		return txnseq;
	}

	public void setTxnseq(String txnseq) {
		this.txnseq = txnseq;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCsn() {
		return csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public String getCardkind() {
		return cardkind;
	}

	public void setCardkind(String cardkind) {
		this.cardkind = cardkind;
	}

	public String getCardmodel() {
		return cardmodel;
	}

	public void setCardmodel(String cardmodel) {
		this.cardmodel = cardmodel;
	}

	public String getCheckcard() {
		return checkcard;
	}

	public void setCheckcard(String checkcard) {
		this.checkcard = checkcard;
	}

	public String getChecktime() {
		return checktime;
	}

	public void setChecktime(String checktime) {
		this.checktime = checktime;
	}

	public String getSamid() {
		return samid;
	}

	public void setSamid(String samid) {
		this.samid = samid;
	}

	public String getUpstationid() {
		return upstationid;
	}

	public void setUpstationid(String upstationid) {
		this.upstationid = upstationid;
	}

	public String getDownstationid() {
		return downstationid;
	}

	public void setDownstationid(String downstationid) {
		this.downstationid = downstationid;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public String getCardseq() {
		return cardseq;
	}

	public void setCardseq(String cardseq) {
		this.cardseq = cardseq;
	}

	public String getCardenddt() {
		return cardenddt;
	}

	public void setCardenddt(String cardenddt) {
		this.cardenddt = cardenddt;
	}

	public String getCardappenddt() {
		return cardappenddt;
	}

	public void setCardappenddt(String cardappenddt) {
		this.cardappenddt = cardappenddt;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getTvm() {
		return tvm;
	}

	public void setTvm(String tvm) {
		this.tvm = tvm;
	}

	public String getTvr() {
		return tvr;
	}

	public void setTvr(String tvr) {
		this.tvr = tvr;
	}

	public String getRand() {
		return rand;
	}

	public void setRand(String rand) {
		this.rand = rand;
	}

	public String getIfd() {
		return ifd;
	}

	public void setIfd(String ifd) {
		this.ifd = ifd;
	}

	public String getAppdata() {
		return appdata;
	}

	public void setAppdata(String appdata) {
		this.appdata = appdata;
	}

	public String getAtc() {
		return atc;
	}

	public void setAtc(String atc) {
		this.atc = atc;
	}

	public String getAip() {
		return aip;
	}

	public void setAip(String aip) {
		this.aip = aip;
	}

	public String getTrandt() {
		return trandt;
	}

	public void setTrandt(String trandt) {
		this.trandt = trandt;
	}

	public String getTxnrsp() {
		return txnrsp;
	}

	public void setTxnrsp(String txnrsp) {
		this.txnrsp = txnrsp;
	}

	public String getTrantp() {
		return trantp;
	}

	public void setTrantp(String trantp) {
		this.trantp = trantp;
	}

	public String getStatecode() {
		return statecode;
	}

	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getAmtcode() {
		return amtcode;
	}

	public void setAmtcode(String amtcode) {
		this.amtcode = amtcode;
	}

	public String getCptinfo() {
		return cptinfo;
	}

	public void setCptinfo(String cptinfo) {
		this.cptinfo = cptinfo;
	}

	public String getOtheramt() {
		return otheramt;
	}

	public void setOtheramt(String otheramt) {
		this.otheramt = otheramt;
	}

	public String getCvmr() {
		return cvmr;
	}

	public void setCvmr(String cvmr) {
		this.cvmr = cvmr;
	}

	public String getTermtp() {
		return termtp;
	}

	public void setTermtp(String termtp) {
		this.termtp = termtp;
	}

	public String getDf() {
		return df;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public String getAppversion() {
		return appversion;
	}

	public void setAppversion(String appversion) {
		this.appversion = appversion;
	}

	public String getTxnseqcount() {
		return txnseqcount;
	}

	public void setTxnseqcount(String txnseqcount) {
		this.txnseqcount = txnseqcount;
	}

	public String getEcauthcode() {
		return ecauthcode;
	}

	public void setEcauthcode(String ecauthcode) {
		this.ecauthcode = ecauthcode;
	}

	public String getCardprdokind() {
		return cardprdokind;
	}

	public void setCardprdokind(String cardprdokind) {
		this.cardprdokind = cardprdokind;
	}

	public String getAccouttype() {
		return accouttype;
	}

	public void setAccouttype(String accouttype) {
		this.accouttype = accouttype;
	}

	private String appversion;// 应用版本号
	private String txnseqcount;// 交易序列计数器
	private String ecauthcode;// 电子现金发卡行授权码
	private String cardprdokind;// 卡产品标识

}
