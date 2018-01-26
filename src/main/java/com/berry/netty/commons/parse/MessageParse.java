package com.berry.netty.commons.parse;

import com.berry.netty.commons.constant.CommonConstant;
import com.berry.netty.commons.utils.JsonUtils;
import com.berry.netty.models.MessageHeader;
import com.berry.netty.models.MessageNetty;
import com.berry.netty.models.MessageBody;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Berry_Cooper
 * @date 2018/1/22.
 */
public class MessageParse {

    private static final Logger logger = LoggerFactory.getLogger(MessageParse.class);

    /**
     * 报文体
     **/
    private static String sourceBody;


    /**
     * 解析报文，返回可操作的消息对象
     *
     * @param ctx
     * @param message 待解析报文（ASCII格式）
     * @return MessageNetty 消息对象
     * @throws Exception 异常
     */
    public static MessageNetty parseMessage(Channel ctx, String message) throws Exception {
        //1.解析报文头
        MessageHeader messageHeader = parseMessageHeader(message);
        logger.info("serverHeader:" + messageHeader);

        //2.组装已解析消息对象
        MessageNetty messageNetty = new MessageNetty();
        //3.消息内容，序列化后获取字节数组
        messageNetty.setMessageBody(JsonUtils.toJson(messageHeader).getBytes());
        messageNetty.setMessageLength(message.length());
        messageNetty.setRemoteAddress(ctx.remoteAddress().toString());
        messageNetty.setTpdu(message.substring(0, 5).getBytes());
        return messageNetty;
    }

    /**
     * 解析报文头
     *
     * @param message 待解析报文
     * @return 报文头信息对象 messageHeader
     */
    private static MessageHeader parseMessageHeader(String message) throws Exception {
        MessageHeader messageHeader = new MessageHeader();
        //F01 0 000000 1002 20170324135657 105152683980000 12345675 000013 000406 0800000000V70old.wav
        // 版本 F01
        messageHeader.setMsgVersion(message.substring(0, 3));
        //是否加密 0
        messageHeader.setMsgEnc(message.substring(3, 4));
        //渠道系统编号 000000
        messageHeader.setClientId(message.substring(4, 10));
        //报文类型 1002
        messageHeader.setMsgType(message.substring(10, 14));
        //发送日期时间 20170324135657
        messageHeader.setMsgTime(message.substring(14, 28));
        //商户号  105152683980000
        messageHeader.setMerchantId(message.substring(28, 43));
        //终端号 12345675
        messageHeader.setTemId(message.substring(43, 51));
        //批次号 000013
        messageHeader.setBatchNum(message.substring(51, 57));
        //终端流水号 000406
        messageHeader.setPosSeqNum(message.substring(57, 63));
        //原报文体
        sourceBody = message.substring(63, message.length());

        //2.根据报文头中版本信息，解析报文体
        MessageBody messageBody;
        switch (messageHeader.getMsgVersion()) {
            case CommonConstant.POS:
                logger.info("POS端发起交易");
                messageBody = getPosTransaction(messageHeader);
                break;
            case CommonConstant.PC:
                logger.info("PC端上传交易");
                messageBody = getPcTransaction(messageHeader);
                break;
            case CommonConstant.QRCODD:
                logger.info("二维码演示");
                messageBody = getQRCodeTransaction(messageHeader);
                break;
            default:
                throw new Exception(CommonConstant.MsgResp.TxnTypeErr.toString());
        }
        messageHeader.setMessageBody(messageBody);

        return messageHeader;
    }

    private static MessageBody getQRCodeTransaction(MessageHeader messageHeader) {
        return null;
    }

    private static MessageBody getPcTransaction(MessageHeader messageHeader) throws Exception {
        MessageBody messageBody;
        MessagesBodyParse bodyParse = new MessagesBodyParse();

        //交易数据上传
        if (CommonConstant.MsgType.pcDataUpload.toString().equals(messageHeader.getMsgType())) {
            messageBody = bodyParse.getPcDataUploadBody(sourceBody);
        } else if (CommonConstant.MsgType.pcPosOff.toString().equals(messageHeader.getMsgType())) {
            //勾兑结果数据返回
            messageBody = bodyParse.getPcPosOffBody(sourceBody);
        } else {
            throw new Exception(CommonConstant.MsgResp.TxnTypeErr.toString());
        }

        return messageBody;
    }

    /**
     * POS 上送的交易
     *
     * @param messageHeader
     * @return
     * @throws Exception
     */
    private static MessageBody getPosTransaction(MessageHeader messageHeader) throws Exception {
        MessagesBodyParse bodyParse = new MessagesBodyParse();

        ServerCampBodyParse campBodyParse = new ServerCampBodyParse();

        //判断交易类型
        MessageBody messageBody;
        switch (messageHeader.getMsgType()) {
            case CommonConstant.PARAMS_DOWNLOAD:
                //参数下载公交
                messageBody = bodyParse.getParaDownBody(sourceBody);
                break;
            case CommonConstant.SIGN_IN:
                //签到
                messageBody = bodyParse.getSignInBody();
                break;
            case CommonConstant.DATA_UPLOAD:
                // 脱机交易上传
                messageBody = bodyParse.getDataUploadBody(sourceBody);
                break;
            case CommonConstant.ISSUE_CATD:
                //M1发卡
                messageBody = bodyParse.getIssueCardBody(sourceBody);
                break;
            case CommonConstant.BUS_PARAMS_DOWNLOAD:
                //公交参数下载
                messageBody = bodyParse.getBusParaDownBody(sourceBody);
                break;
            case CommonConstant.BUS_CHARGE:
                //公交卡充次
                messageBody = bodyParse.getBusCrdChargeTimeBody(sourceBody);
                break;
            case CommonConstant.BUS_CHARGE_NOTICE:
                //公交卡充次通知
                messageBody = bodyParse.getBusCrdChargeTimeNoticeBody(sourceBody);
                break;
            case CommonConstant.PBOC_ISSUE_CARD:
                //pboc发卡
                messageBody = bodyParse.getPBOCIssueCardBody(sourceBody);
                break;
            case CommonConstant.PARAMS_DOWNLOAD_CAMP:
                //参数下载园区
                messageBody = campBodyParse.getParaDownBody(sourceBody);
                break;
            case CommonConstant.CAMP_SIGN_IN:
                //园区签到
                messageBody = campBodyParse.getSignInBody();
                break;
            case CommonConstant.CAMP_DATA_UPLOAD:
                // 园区脱机交易上传
                messageBody = campBodyParse.getDataUploadBody(sourceBody);
                break;
            case CommonConstant.CAMP_ISSUE_CATD:
                //园区M1发卡
                messageBody = campBodyParse.getIssueCardBody(sourceBody);
                break;
            case CommonConstant.CAMP_PARAMS_DOWNLOAD:
                //园区参数下载
                messageBody = campBodyParse.getCampParaDownBody(sourceBody);
                break;
            case CommonConstant.CAMP_CHARGE:
                //园区卡充值
                messageBody = campBodyParse.getBusCrdChargeTimeBody(sourceBody);
                break;
            case CommonConstant.CAMP_CHARGE_NOTICE:
                //园区卡充次通知
                messageBody = campBodyParse.getBusCrdChargeTimeNoticeBody(sourceBody);
                break;
            case CommonConstant.CAMP_PBOC_ISSUE_CATD:
                //园区pboc发卡
                messageBody = campBodyParse.getPBOCCamPIssueCardBody(sourceBody);
                break;
            case CommonConstant.CAMP_STORAGE:
                //园区圈存
                messageBody = campBodyParse.getCampStorageBody(sourceBody);
                break;
            case CommonConstant.CAMP_PBOC_CHARGE:
                //园区PBOC充值
                messageBody = campBodyParse.getCampPbocChargeBody(sourceBody);
                break;
            default:
                throw new Exception(CommonConstant.MsgResp.TxnTypeErr.toString());

        }
        return messageBody;
    }


}
