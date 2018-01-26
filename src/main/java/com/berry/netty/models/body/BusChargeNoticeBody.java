package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

/**
 * 公交卡充次通知
 *
 * @author tanhaiwen
 */
@Data
public class BusChargeNoticeBody implements MessageBody {
    /**
     * 交易类型 : 01:充值冲次查询 02:充值冲次确认
     */
    private String txnType;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 卡片认证码
     */
    private String cardCode;
    /**
     * 卡片CSN
     */
    private String csn;
    /**
     * 卡序列号
     */
    private String cardSeq;
    /**
     * 充值网点编号
     */
    private String nodeNum;
    /**
     * 卡片余次
     */
    private String cardCount;
    /**
     * 冲次次数
     */
    private String txnCount;
    /**
     * 卡类型
     */
    private String cardKind;
    /**
     * 银行编号
     */
    private String bankId;
    /**
     * 年检日期
     */
    private String checkDate;
    /**
     * 有效期
     */
    private String endDate;
    /**
     * 业务类型编号
     */
    private String businessId;
    /**
     * 卡物理类型
     */
    private String physicType;
    /**
     * 区域编号
     */
    private String areaId;
    /**
     * 城市代码
     */
    private String cityCode;
    /**
     * M1卡TAC
     */
    private String tac;
    /**
     * 授权次数
     */
    private String authCount;
    /**
     * 年检日期
     */
    private String cardYearTime;
    /**
     * 重置状态
     */
    private String resetStatus;

}
