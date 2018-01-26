package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

@Data
public class ChargetimebBody implements MessageBody {
    /**
     * 授权次数
     */
    private String authCount;
    /**
     * M1卡2,3,4,5,6扇区KEY
     */
    private String key23456;
    /**
     * M1卡7,8,9扇区KEYB
     */
    private String key789;
    /**
     * 年检日期
     */
    private String crdYearTime;

}
