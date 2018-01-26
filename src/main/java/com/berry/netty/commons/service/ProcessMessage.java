package com.berry.netty.commons.service;

import com.alibaba.fastjson.JSONObject;
import com.berry.netty.busbusiness.ParaDownloadBusiness;
import com.berry.netty.commons.constant.CommonConstant;
import com.berry.netty.commons.utils.ConvertTools;
import com.berry.netty.commons.utils.JsonUtils;
import com.berry.netty.models.MessageBody;
import com.berry.netty.models.MessageNetty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Berry_Cooper
 * @date 2018/1/22.
 */
@Service
@Scope("prototype")
public class ProcessMessage {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理消息业务
     *
     * @param messageNetty
     * @return
     * @throws Exception
     */
    public MessageNetty processMessage(MessageNetty messageNetty) throws Exception {
        String hexString = ConvertTools.bytesToHexString(messageNetty.getMessageBody());
        String asciiString = ConvertTools.convertHexToASCIIString(hexString);
        System.out.println("asciiString" + asciiString);
        //1. 接受消息体-ASCII字符
        JSONObject jsonObject = JSONObject.parseObject(asciiString);
        //2. 处理业务，封包返回
        return doBusinessBYMsgType(jsonObject);
    }

    /**
     * 根据消息类型，进行相关业务，并封装返回消息体
     *
     * @param jsonObject 接受的消息体
     * @return MessageNetty
     * @throws Exception 异常
     */
    private MessageNetty doBusinessBYMsgType(JSONObject jsonObject) throws Exception {
        //判断交易类型
        MessageBody messageBody = null;
        switch (jsonObject.get("msgType").toString()) {
            case CommonConstant.PARAMS_DOWNLOAD:
                //参数下载公交,业务处理
                logger.info("处理参数下载公交业务");
                ParaDownloadBusiness paraDownloadBusiness = new ParaDownloadBusiness();
                messageBody = paraDownloadBusiness.doBusiness(jsonObject);
                break;
            case CommonConstant.SIGN_IN:
                //签到,业务处理
                break;
            case CommonConstant.DATA_UPLOAD:
                // 脱机交易上传,业务处理
                break;
            case CommonConstant.ISSUE_CATD:
                //M1发卡,业务处理
                break;
            case CommonConstant.BUS_PARAMS_DOWNLOAD:
                //公交参数下载,业务处理
                break;
            case CommonConstant.BUS_CHARGE:
                //公交卡充次,业务处理
                break;
            case CommonConstant.BUS_CHARGE_NOTICE:
                //公交卡充次通知,业务处理
                break;
            case CommonConstant.PBOC_ISSUE_CARD:
                //pboc发卡,业务处理
                break;
            case CommonConstant.PARAMS_DOWNLOAD_CAMP:
                //参数下载园区,业务处理
                break;
            case CommonConstant.CAMP_SIGN_IN:
                //园区签到,业务处理
                break;
            case CommonConstant.CAMP_DATA_UPLOAD:
                // 园区脱机交易上传,业务处理
                break;
            case CommonConstant.CAMP_ISSUE_CATD:
                //园区M1发卡,业务处理
                break;
            case CommonConstant.CAMP_PARAMS_DOWNLOAD:
                //园区参数下载,业务处理
                break;
            case CommonConstant.CAMP_CHARGE:
                //园区卡充值,业务处理
                break;
            case CommonConstant.CAMP_CHARGE_NOTICE:
                //园区卡充次通知,业务处理
                break;
            case CommonConstant.CAMP_PBOC_ISSUE_CATD:
                //园区pboc发卡,业务处理
                break;
            case CommonConstant.CAMP_STORAGE:
                //园区圈存,业务处理
                break;
            case CommonConstant.CAMP_PBOC_CHARGE:
                //园区PBOC充值,业务处理
                break;
            default:
                throw new Exception(CommonConstant.MsgResp.TxnTypeErr.toString());

        }
        //封装返回消息
        MessageNetty responseMessageNetty = new MessageNetty();
        System.out.println(JsonUtils.toJson(messageBody));
        byte[] msgByte = Objects.requireNonNull(JsonUtils.toJson(messageBody)).getBytes();
        System.out.println("responseMsgByte:" + Arrays.toString(msgByte));
        responseMessageNetty.setMessageBody(msgByte);
        responseMessageNetty.setMessageLength(msgByte.length);
        return responseMessageNetty;
    }

}
