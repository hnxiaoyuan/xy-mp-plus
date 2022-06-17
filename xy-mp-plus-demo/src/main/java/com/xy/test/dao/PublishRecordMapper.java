package com.xy.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xy.test.constant.Constants;
import com.xy.mplus.core.annotation.HttpRequestDynamicTableName;
import com.xy.test.model.PublishRecordPO;

/**
 * 发布记录表(t_publish_record)数据Mapper
 *
 * @author xiaoyuan
 * @since 2022-03-03 11:23:01
 * @description Auto created
*/
@HttpRequestDynamicTableName(prefix = Constants.BIZ_ID_HEADER)
public interface PublishRecordMapper extends BaseMapper<PublishRecordPO> {

}
