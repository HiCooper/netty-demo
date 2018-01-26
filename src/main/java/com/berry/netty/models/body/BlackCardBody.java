package com.berry.netty.models.body;


import lombok.Data;

/**
 * 参数下载 - 黑名单下载
 */
@Data
public class BlackCardBody {

    /**
     * 长度
     */
    private String cardLen;
    /**
     * 卡号
     */
    private String cardNo;

}
