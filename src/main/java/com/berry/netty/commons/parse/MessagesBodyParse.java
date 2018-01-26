package com.berry.netty.commons.parse;

import com.berry.netty.commons.constant.CommonConstant;
import com.berry.netty.models.body.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析报文体
 *
 * @author 西
 */
public class MessagesBodyParse {

    final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 参数下载报文体
     *
     * @param sourceBody
     * @return
     * @throws
     * @author xi.xu
     * @date 2015年7月6日 下午1:48:26
     */
    public ParaDownloadBody getParaDownBody(String sourceBody) {

        ParaDownloadBody body = new ParaDownloadBody();

        //下载类型
        body.setParaType(sourceBody.substring(0, 2));

        //下载索引
        body.setParaIndex(sourceBody.substring(2, 10));

        // 文件下载或者查询接受到的数据文件信息
        if (sourceBody.length() > 10 && (sourceBody.charAt(10) != 0 && sourceBody.length() == 43)) {
            // 文件名称
            body.setFileName(sourceBody.substring(10, 35));
            // 文件大小
            body.setFileSize(sourceBody.substring(35, 43));
        } else if (sourceBody.length() > 10 && (sourceBody.charAt(10) != 0 && sourceBody.length() > 43)) {
            body.setRecdata(sourceBody.substring(10));
        }

        return body;
    }

    /**
     * 空报文体（占位）
     *
     * @return
     * @throws
     * @author gyh
     * @date 2015年7月7日 下午4:40:22
     */
    public SignInBody getSignInBody() {
        return new SignInBody();
    }

    /**
     * 脱机交易上传报文体
     *
     * @param sourceBody
     * @return
     * @throws
     * @author tanhw
     * @date 2015年7月9日 上午11:09:14
     */
    public DataUploadBody getDataUploadBody(String sourceBody) {

        // 脱机交易上传Model
        DataUploadBody body = new DataUploadBody();

        String sum = sourceBody.substring(0, 2);

        String otherBody = sourceBody.substring(2);

        List<String> list = subStrbody(Integer.parseInt(sum), otherBody, null);

        List<DataRecordsBody> recordsBodyList = new ArrayList<>();

        for (String str : list) {

            DataRecordsBody recordsBody = new DataRecordsBody();

            // 记录长度
            recordsBody.setRecordlen(str.substring(0, 3));
            // 采集点编号
            recordsBody.setCollectid(str.substring(3, 9));
            // 车辆编号
            recordsBody.setBusid(str.substring(9, 17));
            // 线路代码
            recordsBody.setLinecode(str.substring(17, 25));
            // 商户号
            recordsBody.setMchtid(str.substring(25, 40));
            // 终端号
            recordsBody.setTermid(str.substring(40, 48));
            // 城市代码
            recordsBody.setCitycode(str.substring(48, 52));
            // 业务类型编码
            recordsBody.setBusiid(str.substring(52, 56));
            // 交易前卡片余额
            recordsBody.setBefbal(str.substring(56, 68));
            // 原交易金额
            recordsBody.setOritxnamt(str.substring(68, 80));
            // 交易金额
            recordsBody.setTxnamt(str.substring(80, 92));
            // 交易日期时间
            recordsBody.setTxndatetime(str.substring(92, 106));
            // 交易POS流水号
            recordsBody.setTxnseq(str.substring(106, 112));
            // 卡号
            recordsBody.setCardno(str.substring(112, 131));
            // 卡片CSN
            recordsBody.setCsn(str.substring(131, 139));
            // 卡种类型
            recordsBody.setCardkind(str.substring(139, 143));
            // 卡物理类型
            recordsBody.setCardmodel(str.substring(143, 144));
            // 司机卡号
            recordsBody.setCheckcard(str.substring(144, 163));
            // 司机刷卡时间
            recordsBody.setChecktime(str.substring(163, 177));
            // pasm卡号
            recordsBody.setSamid(str.substring(177, 193));
            // 上车站点
            recordsBody.setUpstationid(str.substring(193, 201));
            // 下车站点
            recordsBody.setDownstationid(str.substring(201, 209));
            //消费标识  00扣次 01扣钱
            recordsBody.setAccouttype(str.substring(209, 211));

            if ("  ".equals(recordsBody.getAccouttype())) {
                recordsBody.setAccouttype(CommonConstant.AccountType.OTHER.toString());
            }

            // 保留域
            recordsBody.setReserved(str.substring(211, 273));
            // M1TAC
            recordsBody.setTac(str.substring(273, 281));
            // 卡片序号
            recordsBody.setCardseq(str.substring(281, 284));
            // 卡有效期
            recordsBody.setCardenddt(str.substring(284, 288));
            // 卡应用有效期
            recordsBody.setCardappenddt(str.substring(288, 292));
            // 应用编号
            recordsBody.setAid(str.substring(292, 308));
            // 应用密文
            recordsBody.setAc(str.substring(308, 324));
            // 终端性能
            recordsBody.setTvm(str.substring(324, 330));
            // 终端验证结果
            recordsBody.setTvr(str.substring(330, 340));
            // 不可预知数
            recordsBody.setRand(str.substring(340, 348));
            // 接口设备序列号
            recordsBody.setIfd(str.substring(348, 356));
            // 发卡行应用数据
            recordsBody.setAppdata(str.substring(356, 420));
            // 应用交易计数器
            recordsBody.setAtc(str.substring(420, 424));
            // 应用交互特征
            recordsBody.setAip(str.substring(424, 428));
            // 交易日期
            recordsBody.setTrandt(str.substring(428, 434));
            // 交易响应码
            recordsBody.setTxnrsp(str.substring(434, 436));
            // 交易类型
            recordsBody.setTrantp(str.substring(436, 438));
            // 终端国家代码
            recordsBody.setStatecode(str.substring(438, 441));
            // 交易货币代码
            recordsBody.setAmtcode(str.substring(441, 444));
            // 密文信息数据
            recordsBody.setCptinfo(str.substring(444, 446));
            // 其他金额
            recordsBody.setOtheramt(str.substring(446, 458));
            // 持卡人验证方法结果
            recordsBody.setCvmr(str.substring(458, 464));
            // 终端类型
            recordsBody.setTermtp(str.substring(464, 466));
            // 专用文件名
            recordsBody.setDf(str.substring(466, 498));
            // 应用版本号
            recordsBody.setAppversion(str.substring(498, 502));
            // 交易序列计数器
            recordsBody.setTxnseqcount(str.substring(502, 510));
            // 电子现金发卡行授权码
            recordsBody.setEcauthcode(str.substring(510, 516));
            // 卡产品标识
            recordsBody.setCardprdokind(str.substring(516, 540));
            recordsBodyList.add(recordsBody);

        }

        // 记录数
        body.setRecords(sum);
        body.setRecordsBodyList(recordsBodyList);

        return body;
    }

    /**
     * 返回截取数据列表
     *
     * @param @param  sum
     * @param @param  strBody
     * @param @param  strBodyList
     * @param @return
     * @throws
     * @author tanhw
     * @date 2015年7月10日 下午4:49:18
     */
    private static List<String> subStrbody(int sum, String strBody,
                                           List<String> strBodyList) {

        if (sum-- <= 0) {
            return strBodyList;
        }

        if (strBodyList == null) {
            strBodyList = new ArrayList<>();
        }

        // length
        int length = Integer.parseInt(strBody.substring(0, 3));

        strBodyList.add(strBody.substring(0, length + 3));

        strBody = strBody.substring(length + 3);

        return subStrbody(sum, strBody, strBodyList);
    }

    /**
     * 发卡报文体
     *
     * @param body 报文体
     * @return
     * @author rain
     */

    public IssueCardBody getIssueCardBody(String body) {

        IssueCardBody issueCardBody = new IssueCardBody();

        //交易类型
        issueCardBody.setTxntype(body.substring(0, 2));
        //卡号
        issueCardBody.setCardno(body.substring(2, 21));
        //卡片认证码
        issueCardBody.setCardcode(body.substring(21, 22));
        //卡片CSN
        issueCardBody.setCsn(body.substring(22, 30));
        //卡序列号
        issueCardBody.setCrdpanseq(body.substring(30, 33));
        //开户机构
        issueCardBody.setNodenum(body.substring(33, 41));

        // 默认不以卡片余额为准
        issueCardBody.setAccountbal(9000000L);
        if (body.length() >= 53) {
            try {
                long cardBalance = Long.parseLong(body.substring(41, 53));
                if (cardBalance >= 0) {
                    // 当前卡片内余额
                    issueCardBody.setAccountbal(cardBalance);
                }
            } catch (Exception e) {
                logger.error("解析当前卡片余额错误");
                logger.info(e.getMessage());
            }

        }
        return issueCardBody;
    }

    /**
     * 公交参数下载报文体
     *
     * @param body
     * @return
     * @author rain
     */
    public BusParaDownBody getBusParaDownBody(String body) {

        BusParaDownBody busParaDownBody = new BusParaDownBody();

        //参数类型
        busParaDownBody.setParaType(body.substring(0, 2));
        //参数索引
        busParaDownBody.setParaIndex(body.substring(2, 10));

        return busParaDownBody;
    }


    /**
     * 公交卡充次报文体
     *
     * @param @param body
     * @return BusCardChargeTimeBody
     * @throws
     * @author tanhw
     * @date 2015年7月14日 下午3:56:01
     */
    public BusChargeBody getBusCrdChargeTimeBody(String body) {

        BusChargeBody chargeTimeBody = new BusChargeBody();

        // 交易类型
        chargeTimeBody.setTxnType(body.substring(0, 2));
        // 卡号
        chargeTimeBody.setCardNo(body.substring(2, 21));
        // 卡片认证码
        chargeTimeBody.setCardCode(body.substring(21, 22));
        // 卡片csn序列号
        chargeTimeBody.setCsn(body.substring(22, 30));
        // 卡片序列号
        chargeTimeBody.setCardSeq(body.substring(30, 33));
        // 充值网点编号
        chargeTimeBody.setNodeNum(body.substring(33, 41));
        // 卡片余次
        chargeTimeBody.setCardCount(body.substring(41, 53));
        // 冲次次数
        chargeTimeBody.setTxnCount(body.substring(53, 65));
        // M1卡TAC
        chargeTimeBody.setTac(body.substring(65, 73));

        return chargeTimeBody;

    }

    /**
     * 解析公交卡充次通知报文体
     *
     * @param @param body
     * @return timeNoticeBody
     * @throws
     * @author tanhw
     * @date 2015年7月15日 上午10:47:00
     */
    public BusChargeNoticeBody getBusCrdChargeTimeNoticeBody(String body) {

        BusChargeNoticeBody timeNoticeBody = new BusChargeNoticeBody();

        // 交易类型
        timeNoticeBody.setTxnType(body.substring(0, 2));
        // 卡号
        timeNoticeBody.setCardNo(body.substring(2, 21));
        // 卡片认证码
        timeNoticeBody.setCardCode(body.substring(21, 22));
        // 卡片csn序列号
        timeNoticeBody.setCsn(body.substring(22, 30));
        // 卡片序列号
        timeNoticeBody.setCardSeq(body.substring(30, 33));
        // 充值网点编号
        timeNoticeBody.setNodeNum(body.substring(33, 41));
        // 卡片余次
        timeNoticeBody.setCardCount(body.substring(41, 53));
        // 冲次次数
        timeNoticeBody.setTxnCount(body.substring(53, 65));
        // 卡类型
        timeNoticeBody.setCardKind(body.substring(65, 69));
        // 银行编号
        timeNoticeBody.setBankId(body.substring(69, 77));
        // 年检日期
        timeNoticeBody.setCheckDate(body.substring(77, 85));
        // 有效期
        timeNoticeBody.setEndDate(body.substring(85, 93));
        // 业务类型编号
        timeNoticeBody.setBusinessId(body.substring(93, 97));
        // 卡物理类型
        timeNoticeBody.setPhysicType(body.substring(97, 98));
        // 区域编号
        timeNoticeBody.setAreaId(body.substring(98, 106));
        // 城市代码
        timeNoticeBody.setCityCode(body.substring(106, 110));
        // M1卡TAC
        timeNoticeBody.setTac(body.substring(110, 118));

        if (body.length() > 118 && body.charAt(118) != 0) {
            String resetStat = body.substring(118, 119);
            if (resetStat.charAt(0) >= '0' || resetStat.charAt(0) <= '9') {
                //重置状态
                timeNoticeBody.setResetStatus(resetStat);
            } else {
                //默认不重置
                timeNoticeBody.setResetStatus(CommonConstant.ResetStat.UseCard.toString());
            }

        } else {
            //默认不重置
            timeNoticeBody.setResetStatus(CommonConstant.ResetStat.UseCard.toString());
        }

        return timeNoticeBody;
    }

    public PBOCIssueCardBody getPBOCIssueCardBody(String body) {

        PBOCIssueCardBody pbocIssueCardBody = new PBOCIssueCardBody();

        //交易类型	01发卡
        pbocIssueCardBody.setTxntype(body.substring(0, 2));
        // 版本	0001
        pbocIssueCardBody.setVersion(body.substring(2, 6));
        //银行编号
        pbocIssueCardBody.setBankid(body.substring(6, 14));
        //应用索引
        pbocIssueCardBody.setAppindex(body.substring(14, 16));
        //短文件表示符
        pbocIssueCardBody.setSfi(Integer.toHexString(0xFF & body.charAt(16)));
        //记录号
        pbocIssueCardBody.setRecordnumber(body.substring(17, 19));
        //卡号
        pbocIssueCardBody.setPan(body.substring(19, 38));
        //卡序列号
        pbocIssueCardBody.setPanid(body.substring(38, 42));
        //卡片唯一序列号
        pbocIssueCardBody.setCsn(body.substring(42, 50));
        //交易计数器
        pbocIssueCardBody.setAtc(body.substring(50, 54));
        //行业应用开通密钥索引
        pbocIssueCardBody.setAppopenkeyidx(body.substring(54, 57));
        //行业应用管理密钥索引
        pbocIssueCardBody.setAppmgrkeyidx(body.substring(57, 60));
        // 后续字节保留
        pbocIssueCardBody.setFollow(body.substring(60, 64));
        return pbocIssueCardBody;

    }

    public DataUploadBody getPcDataUploadBody(String body) {
        // 脱机交易上传Mode
        DataUploadBody dataUploadBody = new DataUploadBody();
        //记录数
        int num = Integer.parseInt(body.substring(0, 6));
        // 记录长度
        int length = Integer.parseInt(body.substring(6, 10));

        String str = body.substring(10, body.length());
        int i = 0;

        List<DataRecordsBody> list = new ArrayList<DataRecordsBody>();
        for (int j = 0; j < num; j++) {
            DataRecordsBody recordsBody = new DataRecordsBody();
            i = j * length;
            // 采集点编号
            recordsBody.setCollectid(str.substring(i, i + 6));
            i = i + 6;
            // 车辆编号
            recordsBody.setBusid(str.substring(i, i + 8));
            i = i + 8;
            // 线路代码
            recordsBody.setLinecode(str.substring(i, i + 8));
            i = i + 8;
            // 商户号
            recordsBody.setMchtid(str.substring(i, i + 15));
            i = i + 15;
            // 终端号
            recordsBody.setTermid(str.substring(i, i + 8));
            i = i + 8;
            // 城市代码
            recordsBody.setCitycode(str.substring(i, i + 4));
            i = i + 4;
            // 业务类型编码
            recordsBody.setBusiid(str.substring(i, i + 4));
            i = i + 4;
            // 交易前卡片余额
            recordsBody.setBefbal(str.substring(i, i + 12));
            i = i + 12;
            // 原交易金额
            recordsBody.setOritxnamt(str.substring(i, i + 12));
            i = i + 12;
            // 实际交易金额
            recordsBody.setTxnamt(str.substring(i, i + 12));
            i = i + 12;
            // 交易日期时间
            recordsBody.setTxndatetime(str.substring(i, i + 14));
            i = i + 14;
            // 交易POS流水号
            recordsBody.setTxnseq(str.substring(i, i + 6));
            i = i + 6;
            // 卡号
            recordsBody.setCardno(str.substring(i, i + 19));
            i = i + 19;
            // 卡片CSN
            recordsBody.setCsn(str.substring(i, i + 8));
            i = i + 8;
            // 卡种类型
            recordsBody.setCardkind(str.substring(i, i + 4));
            i = i + 4;
            // 卡物理类型
            recordsBody.setCardmodel(str.substring(i, i + 1));
            i = i + 1;
            // PSAM卡号
            recordsBody.setSamid(str.substring(i, i + 16));
            i = i + 16;
            // 上车站点
            recordsBody.setUpstationid(str.substring(i, i + 8));
            i = i + 8;
            // 下车站点
            recordsBody.setDownstationid(str.substring(i, i + 8));
            i = i + 8;
            // 消费类型
            recordsBody.setAccouttype(str.substring(i, i + 2));
            i = i + 2;
            // M1TAC
            recordsBody.setTac(str.substring(i, i + 8));
            i = i + 8;
            // 卡片序号
            recordsBody.setCardseq(str.substring(i, i + 3));
            i = i + 3;
            // 卡有效期
            recordsBody.setCardenddt(str.substring(i, i + 4));
            i = i + 4;
            // 卡应用有效期
            str.substring(i, i + 4);
            i = i + 4;
            // 应用编号
            recordsBody.setAid(str.substring(i, i + 16));
            i = i + 16;
            // 应用密文
            recordsBody.setAc(str.substring(i, i + 16));
            i = i + 16;
            // 终端性能
            recordsBody.setTvm(str.substring(i, i + 6));
            i = i + 6;
            // 终端验证结果
            recordsBody.setTvr(str.substring(i, i + 10));
            i = i + 10;
            // 不可预知数
            recordsBody.setRand(str.substring(i, i + 8));
            i = i + 8;
            // 接口设备序列号
            recordsBody.setIfd(str.substring(i, i + 8));
            i = i + 8;
            // 发卡行应用数据
            recordsBody.setAppdata(str.substring(i, i + 64));
            i = i + 64;
            // 应用交易计数器
            recordsBody.setAtc(str.substring(i, i + 4));
            i = i + 4;
            // 应用交互特征
            recordsBody.setAip(str.substring(i, i + 4));
            i = i + 4;
            // 交易日期
            recordsBody.setTrandt(str.substring(i, i + 6));
            i = i + 6;
            // 交易响应码
            recordsBody.setTxnrsp(str.substring(i, i + 2));
            i = i + 2;
            // 交易类型
            recordsBody.setTrantp(str.substring(i, i + 2));
            i = i + 2;
            // 终端国家代码
            recordsBody.setStatecode(str.substring(i, i + 3));
            i = i + 3;
            // 交易货币代码
            recordsBody.setAmtcode(str.substring(i, i + 3));
            i = i + 3;
            // 密文信息数据
            recordsBody.setCptinfo(str.substring(i, i + 2));
            i = i + 2;
            // 其他金额
            recordsBody.setOtheramt(str.substring(i, i + 12));
            i = i + 12;
            // 持卡人验证方法结果
            recordsBody.setCvmr(str.substring(i, i + 6));
            i = i + 6;
            // 终端类型
            recordsBody.setTermtp(str.substring(i, i + 2));
            i = i + 2;
            // 专用文件名
            recordsBody.setDf(str.substring(i, i + 32).trim());
            i = i + 32;
            // 应用版本号
            recordsBody.setAppversion(str.substring(i, i + 4));
            i = i + 4;
            // 交易序列计数器
            recordsBody.setTxnseqcount(str.substring(i, i + 8).trim());
            i = i + 8;
            // 电子现金发卡行授权码
            recordsBody.setEcauthcode(str.substring(i, i + 6));
            i = i + 6;
            // 卡产品标识
            recordsBody.setCardprdokind(str.substring(i, i + 24));
            i = i + 24;
            list.add(recordsBody);
        }

        dataUploadBody.setRecordsBodyList(list);
        return dataUploadBody;
    }

    public PcPosOffBody getPcPosOffBody(String body) {

        PcPosOffBody pcPosOffBody = new PcPosOffBody();
        // 批量日期
        pcPosOffBody.setBatchDate(body.substring(0, 8));
        //参数索引
        pcPosOffBody.setParaIndex(body.substring(8, 16));

        return pcPosOffBody;

    }

}
