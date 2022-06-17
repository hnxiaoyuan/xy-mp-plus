package com.xy.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xy.mplus.core.annotation.HttpRequestDynamicTableName;
import com.xy.mplus.core.annotation.SpelDynamicTableName;
import com.xy.test.constant.Constants;
import com.xy.test.model.PublishRecordPO;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
@HttpRequestDynamicTableName(prefix = Constants.BIZ_ID_HEADER)
public interface PublishRecordService extends IService<PublishRecordPO> {

    @SpelDynamicTableName(prefix = "'b'.concat(#bizId)")
    Object getList(String bizId);

    Object getItemOne(String bizId);
}
