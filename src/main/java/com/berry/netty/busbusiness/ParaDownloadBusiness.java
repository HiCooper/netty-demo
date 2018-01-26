package com.berry.netty.busbusiness;

import com.alibaba.fastjson.JSONObject;
import com.berry.netty.commons.utils.JsonUtils;
import com.berry.netty.models.body.ParaDownloadBody;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Berry_Cooper
 * @date 2018/1/25.
 */
@Service
@Scope("prototype")
public class ParaDownloadBusiness {

    public ParaDownloadBody doBusiness(JSONObject jsonObject) throws Exception {
        ParaDownloadBody paraDownloadBody = JsonUtils.json2obj(jsonObject.get("messageBody").toString(), ParaDownloadBody.class);
        //todo paraDownloadBody.setXxxxx();
        return paraDownloadBody;
    }
}
