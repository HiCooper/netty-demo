package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

@Data
public class BusParaDownBody implements MessageBody {

    /**
     * 请求报文参数类型  :01-线路基础票价信息 ,02-线路多级票价信息,03-充值金额次数比例信息
     */
    private String paraType;
    /**
     * 参数索引
     */
    private String paraIndex;

    /*
     * ****应答报文
     */

    /**
     * 参数总长度
     */
    private String paraLen;
    /**
     * 线路编号
     */
    private String lineCode;
    /**
     * 票价类型0-基础票价
     */
    private String feeType;
    /**
     * 线路名称
     */
    private String lineName;
    /**
     * 内部卡类型
     */
    private String cardKind;
    /**
     * 扣费类型（0-余额，1-余次）
     */
    private String deductionType;
    /**
     * 清次周期类型
     */
    private String periodType;
    /**
     * 清次次数
     */
    private String clearTimes;
    /**
     * 基础价格
     */
    private String basePrice;
    /**
     * 优惠比例
     */
    private String discount;
    /**
     * 生效日期(YYMMDD)
     */
    private String effectTime;
    /**
     * 业务类型
     */
    private String businessId;
    /**
     * 次数兑换比例
     */
    private String timeSubscriptionRatio;
    /**
     * 金额兑换比例
     */
    private String amountSubscriptionRatio;
    /**
     * 返回报文重复部分
     */
    private String sonBody;

    /*
     * *****多级票价
     */
    /**
     * 版本号
     */
    private String version;
    /**
     * 站点数
     */
    private String stationNum;
    /**
     * 票价单位长度
     */
    private String currentLen;
    /**
     * 保留
     */
    private String reserve;
    /**
     * 长度
     */
    private String bindDataLen;
    /**
     * 票价数据
     */
    private byte[] data;

}
