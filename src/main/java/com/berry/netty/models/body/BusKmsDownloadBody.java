package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

@Data
public class BusKmsDownloadBody implements MessageBody {
    /**
     * M1卡0,1扇区KEYA
     */
    private String keya01;
    /**
     * M1卡2,3,4,5,6扇区KEYA
     */
    private String keya23456;
    /**
     * M1卡7,8,9扇区KEYA
     */
    private String keya789;
    /**
     * M1卡10,11,12扇区KEYA
     */
    private String keya1011112;

    private byte[] responseBody;

}
