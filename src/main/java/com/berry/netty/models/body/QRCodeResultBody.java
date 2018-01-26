package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

@Data
public class QRCodeResultBody implements MessageBody {
    /**
     * 18位串码
     */
    private String qrCode;
    /**
     * 金额
     */
    private String money;
}
