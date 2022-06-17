package com.xy.mplus.core.annotation;

import com.xy.mplus.domain.TableNameExtraInfo;

import java.lang.reflect.Method;

/**
 * 固定前后缀策略
 * @author xiaoyuan
 * @date 2022-04-08
 */
public class FixedTableNameStrategy implements DynamicTableNameStrategy {

    @Override
    public TableNameExtraInfo handleDynamicTableName(Method targetMethod, Object[] methodArgs, DynamicTableName dynamicTableName) {
        return TableNameExtraInfo.of(dynamicTableName.prefix(), dynamicTableName.suffix());
    }
}
