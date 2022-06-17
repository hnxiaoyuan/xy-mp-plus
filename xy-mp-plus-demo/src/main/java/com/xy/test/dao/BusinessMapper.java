package com.xy.test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xy.mplus.core.annotation.FixedTableName;
import com.xy.test.model.Business;

/**
 * (t_business)数据Mapper
 *
 * @author xiaoyuan
 * @since 2022-04-08 11:20:21
 * @description Auto created
*/
@FixedTableName(prefix = "yibot_web")
public interface BusinessMapper extends BaseMapper<Business> {

    Business selectAllList();
}
