package com.berry.netty.models.body;

import com.berry.netty.models.MessageBody;
import lombok.Data;

import java.util.List;

@Data
public class DataUploadBody implements MessageBody {

    /**
     * 记录数
     */
    private String records;
    /**
     * 脱机交易记录
     */
    private List<DataRecordsBody> recordsBodyList;
    /**
     * 批量日期
     */
    private String batchDate;

}
