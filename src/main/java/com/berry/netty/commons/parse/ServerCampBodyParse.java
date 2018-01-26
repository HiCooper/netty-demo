package com.berry.netty.commons.parse;

import com.berry.netty.models.body.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 园区参数下载
 *
 * @author rain
 */
public class ServerCampBodyParse {

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

        List<DataRecordsBody> recordsBodyList = new ArrayList<DataRecordsBody>();

        for (String str : list) {

            DataRecordsBody recordsBody = new DataRecordsBody();

            recordsBody.setRecordlen(str.substring(0, 3));// 记录长度
            recordsBody.setCollectid(str.substring(3, 9));// 采集点编号
            recordsBody.setBusid(str.substring(9, 17));// 车辆编号
            recordsBody.setLinecode(str.substring(17, 25));// 线路代码
            recordsBody.setMchtid(str.substring(25, 40));// 商户号
            recordsBody.setTermid(str.substring(40, 48));// 终端号
            recordsBody.setCitycode(str.substring(48, 52));// 城市代码
            recordsBody.setBusiid(str.substring(52, 56));// 业务类型编码
            recordsBody.setBefbal(str.substring(56, 68));// 交易前卡片余额
            recordsBody.setOritxnamt(str.substring(68, 80));// 原交易金额
            recordsBody.setTxnamt(str.substring(80, 92));// 交易金额
            recordsBody.setTxndatetime(str.substring(92, 106));// 交易日期时间
            recordsBody.setTxnseq(str.substring(106, 112));// 交易POS流水号
            recordsBody.setCardno(str.substring(112, 131));// 卡号
            recordsBody.setCsn(str.substring(131, 139));// 卡片CSN
            recordsBody.setCardkind(str.substring(139, 143));// 卡种类型
            recordsBody.setCardmodel(str.substring(143, 144));// 卡物理类型
            recordsBody.setCheckcard(str.substring(144, 163));// 司机卡号
            recordsBody.setChecktime(str.substring(163, 177));// 司机刷卡时间
            recordsBody.setSamid(str.substring(177, 193));// pasm卡号
            recordsBody.setUpstationid(str.substring(193, 201)); // 上车站点
            recordsBody.setDownstationid(str.substring(201, 209)); // 下车站点

            recordsBody.setAccouttype(str.substring(209, 211));//账户类型  00电子现金账户 01虚拟账户消费 02依据后台规则

            recordsBody.setReserved(str.substring(211, 273)); // 保留域
            recordsBody.setTac(str.substring(273, 281));// M1TAC
            recordsBody.setCardseq(str.substring(281, 284)); // 卡片序号
            recordsBody.setCardenddt(str.substring(284, 288)); // 卡有效期
            recordsBody.setCardappenddt(str.substring(288, 292));// 卡应用有效期
            recordsBody.setAid(str.substring(292, 308));// 应用编号
            recordsBody.setAc(str.substring(308, 324));// 应用密文
            recordsBody.setTvm(str.substring(324, 330));// 终端性能
            recordsBody.setTvr(str.substring(330, 340));// 终端验证结果
            recordsBody.setRand(str.substring(340, 348));// 不可预知数
            recordsBody.setIfd(str.substring(348, 356));// 接口设备序列号
            recordsBody.setAppdata(str.substring(356, 420));// 发卡行应用数据
            recordsBody.setAtc(str.substring(420, 424));// 应用交易计数器
            recordsBody.setAip(str.substring(424, 428));// 应用交互特征
            recordsBody.setTrandt(str.substring(428, 434));// 交易日期
            recordsBody.setTxnrsp(str.substring(434, 436));// 交易响应码
            recordsBody.setTrantp(str.substring(436, 438));// 交易类型
            recordsBody.setStatecode(str.substring(438, 441));// 终端国家代码
            recordsBody.setAmtcode(str.substring(441, 444));// 交易货币代码
            recordsBody.setCptinfo(str.substring(444, 446));// 密文信息数据
            recordsBody.setOtheramt(str.substring(446, 458));// 其他金额
            recordsBody.setCvmr(str.substring(458, 464));// 持卡人验证方法结果
            recordsBody.setTermtp(str.substring(464, 466));// 终端类型
            recordsBody.setDf(str.substring(466, 498));// 专用文件名
            recordsBody.setAppversion(str.substring(498, 502));// 应用版本号
            recordsBody.setTxnseqcount(str.substring(502, 510));// 交易序列计数器
            recordsBody.setEcauthcode(str.substring(510, 516));// 电子现金发卡行授权码
            recordsBody.setCardprdokind(str.substring(516, 540));// 卡产品标识

            recordsBodyList.add(recordsBody);

        }

        body.setRecords(sum);// 记录数
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
            strBodyList = new ArrayList<String>();
        }

        int lenght = Integer.parseInt(strBody.substring(0, 3)); // length

        strBodyList.add(strBody.substring(0, lenght + 3));

        strBody = strBody.substring(lenght + 3);

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

        issueCardBody.setTxntype(body.substring(0, 2));//交易类型
        issueCardBody.setCardno(body.substring(2, 21));//卡号
        issueCardBody.setCardcode(body.substring(21, 22));//卡片认证码
        issueCardBody.setCsn(body.substring(22, 30)); //卡片CSN
        issueCardBody.setCrdpanseq(body.substring(30, 33));//卡序列号
        issueCardBody.setNodenum(body.substring(33, 41));//开户机构
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

        busParaDownBody.setParaType(body.substring(0, 2)); //参数类型

        busParaDownBody.setParaIndex(body.substring(2, 10)); //参数索引

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
    public CampChargeBody getBusCrdChargeTimeBody(String body) {

        CampChargeBody chargeTimeBody = new CampChargeBody();

        chargeTimeBody.setTxntype(body.substring(0, 2));// 交易类型
        chargeTimeBody.setCardno(body.substring(2, 21));// 卡号
        chargeTimeBody.setCardcode(body.substring(21, 22));// 卡片认证码
        chargeTimeBody.setCsn(body.substring(22, 30));// 卡片csn
        chargeTimeBody.setCardseq(body.substring(30, 33));// 卡片序列号
        chargeTimeBody.setNodenum(body.substring(33, 41));// 充值网点编号
        chargeTimeBody.setTxncount(body.substring(41, 53));// 充值金额
        chargeTimeBody.setCardcount(body.substring(53, 65)); //卡内余额
        chargeTimeBody.setTac(body.substring(65, 73));// M1卡TAC

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

        timeNoticeBody.setTxnType(body.substring(0, 2));// 交易类型
        timeNoticeBody.setCardNo(body.substring(2, 21));// 卡号
        timeNoticeBody.setCardCode(body.substring(21, 22));// 卡片认证码
        timeNoticeBody.setCsn(body.substring(22, 30));// 卡片csn序列号
        timeNoticeBody.setCardSeq(body.substring(30, 33));// 卡片序列号
        timeNoticeBody.setNodeNum(body.substring(33, 41));// 充值网点编号
        timeNoticeBody.setCardCount(body.substring(41, 53));// 卡片余次
        timeNoticeBody.setTxnCount(body.substring(53, 65));// 冲次次数
        timeNoticeBody.setCardKind(body.substring(65, 69)); // 卡类型
        timeNoticeBody.setBankId(body.substring(69, 77));// 银行编号
        timeNoticeBody.setCheckDate(body.substring(77, 85));// 年检日期
        timeNoticeBody.setEndDate(body.substring(85, 93));// 有效期
        timeNoticeBody.setBusinessId(body.substring(93, 97)); // 业务类型编号
        timeNoticeBody.setPhysicType(body.substring(97, 98)); // 卡物理类型
        timeNoticeBody.setAreaId(body.substring(98, 106));// 区域编号
        timeNoticeBody.setCityCode(body.substring(106, 110));// 城市代码
        timeNoticeBody.setTac(body.substring(110, 118));// M1卡TAC

        return timeNoticeBody;
    }

    public PBOCIssueCardBody getPBOCIssueCardBody(String body) {

        PBOCIssueCardBody pbocIssueCardBody = new PBOCIssueCardBody();

        pbocIssueCardBody.setTxntype(body.substring(0, 2)); //交易类型	01发卡  //02更新    //03更新确认

        pbocIssueCardBody.setVersion(body.substring(2, 6)); // 版本	0001
        pbocIssueCardBody.setBankid(body.substring(6, 14)); //银行编号
        pbocIssueCardBody.setAppindex(body.substring(14, 16));//应用索引
        pbocIssueCardBody.setSfi(Integer.toHexString(0xFF & body.charAt(16))); //短文件表示符
        pbocIssueCardBody.setRecordnumber(body.substring(17, 19));//记录号
        pbocIssueCardBody.setPan(body.substring(19, 38));//卡号
        pbocIssueCardBody.setPanid(body.substring(38, 42));//卡序列号
        pbocIssueCardBody.setCsn(body.substring(42, 50));//卡片唯一序列号
        pbocIssueCardBody.setAtc(body.substring(50, 54));//交易计数器
        pbocIssueCardBody.setAppopenkeyidx(body.substring(54, 57)); //行业应用开通密钥索引
        pbocIssueCardBody.setAppmgrkeyidx(body.substring(57, 60));//行业应用管理密钥索引
        pbocIssueCardBody.setFollow(body.substring(60, 64));// 后续字节保留

        return pbocIssueCardBody;

    }


    public PBOCIssueCardBody getPBOCCamPIssueCardBody(String body) {

        PBOCIssueCardBody pbocIssueCardBody = new PBOCIssueCardBody();

        pbocIssueCardBody.setTxntype(body.substring(0, 2)); //交易类型	01发卡  //02更新    //03更新确认

        pbocIssueCardBody.setVersion(body.substring(2, 6)); // 版本	0001
        pbocIssueCardBody.setBankid(body.substring(6, 14)); //银行编号
        pbocIssueCardBody.setAppindex(body.substring(14, 16));//应用索引
        pbocIssueCardBody.setSfi(Integer.toHexString(0xFF & body.charAt(16))); //短文件表示符
        pbocIssueCardBody.setRecordnumber(body.substring(17, 19));//记录号
        pbocIssueCardBody.setPan(body.substring(19, 38));//卡号
        pbocIssueCardBody.setPanid(body.substring(38, 42));//卡序列号
        pbocIssueCardBody.setCsn(body.substring(42, 50));//卡片唯一序列号
        pbocIssueCardBody.setAtc(body.substring(50, 54));//交易计数器
        pbocIssueCardBody.setAppopenkeyidx(body.substring(54, 57)); //行业应用开通密钥索引
        pbocIssueCardBody.setAppmgrkeyidx(body.substring(57, 60));//行业应用管理密钥索引
        pbocIssueCardBody.setCardcount(body.substring(60, 72));//01发卡：02更新 03 更新确认：上送卡内余额
        pbocIssueCardBody.setFollow(body.substring(72, 76));// 后续字节保留

        return pbocIssueCardBody;

    }

    /**
     * 园区下载交易
     */
    public CampParaDownBody getCampParaDownBody(String body) {

        CampParaDownBody campParaDownBody = new CampParaDownBody();

        campParaDownBody.setParaType(body.substring(0, 2)); //参数类型

        campParaDownBody.setParaIndex(body.substring(2, 10)); //参数索引

        return campParaDownBody;
    }

    /**
     * 园区圈存
     *
     * @param body
     * @return
     */
    public CampStorageBody getCampStorageBody(String body) {

        CampStorageBody campStorageBody = new CampStorageBody();

        campStorageBody.setTxnType(body.substring(0, 2)); // 交易类型 01：圈存查询  02：圈存确认

        campStorageBody.setCardNo(body.substring(2, 21)); //卡号

        campStorageBody.setCardCode(body.substring(21, 22)); //卡片认证码

        campStorageBody.setCsn(body.substring(22, 30));//卡片CSN

        campStorageBody.setCrdPanSeq(body.substring(30, 33)); //卡序列号

        campStorageBody.setNodeNum(body.substring(33, 41)); //充值网点编号

        campStorageBody.setTxnCount(body.substring(41, 53));//充值金额

        campStorageBody.setTac(body.substring(53, 61));//M1卡TAC

        return campStorageBody;

    }

    /**
     * 园区PBOC充值
     *
     * @param body
     * @return
     */
    public CampPbocChargeBody getCampPbocChargeBody(String body) {

        CampPbocChargeBody campPbocChargeBody = new CampPbocChargeBody();

        campPbocChargeBody.setTxntype(body.substring(0, 2)); //交易类型
        campPbocChargeBody.setVersion(body.substring(2, 6)); //版本号
        campPbocChargeBody.setBankid(body.substring(6, 14)); //银行编号
        campPbocChargeBody.setAppindex(body.substring(14, 16)); //应用索引
        campPbocChargeBody.setSfi(Integer.toHexString(0xFF & body.charAt(16))); //短文件表示符
        campPbocChargeBody.setRecordnumber(body.substring(17, 19)); //记录号
        campPbocChargeBody.setPan(body.substring(19, 38));//卡号
        campPbocChargeBody.setPanid(body.substring(38, 42));//卡序列号
        campPbocChargeBody.setCsn(body.substring(42, 50));//卡片唯一序列号
        campPbocChargeBody.setAtc(body.substring(50, 54));//交易计数器
        campPbocChargeBody.setAppopenkeyidx(body.substring(54, 57)); //行业应用开通密钥索引
        campPbocChargeBody.setAppmgrkeyidx(body.substring(57, 60));//行业应用管理密钥索引
        campPbocChargeBody.setNodenum(body.substring(60, 68));//充值网点编号
        campPbocChargeBody.setCardcount(body.substring(68, 80)); //卡内余额
        campPbocChargeBody.setTxncount(body.substring(80, 92));//充值金额
        campPbocChargeBody.setTac(body.substring(92, 100));//m1卡TAC

        return campPbocChargeBody;
    }

}
