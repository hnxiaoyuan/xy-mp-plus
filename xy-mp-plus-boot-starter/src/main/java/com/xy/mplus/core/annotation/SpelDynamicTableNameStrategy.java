package com.xy.mplus.core.annotation;

import com.xy.mplus.domain.TableNameExtraInfo;
import com.xy.mplus.util.SpelUtil;

import java.lang.reflect.Method;

/**
 * 通过spel表达式获取表名前缀和后缀
 * @author xiaoyuan
 * @date 2022-04-07
 */
public class SpelDynamicTableNameStrategy implements DynamicTableNameStrategy {

    @Override
    public TableNameExtraInfo handleDynamicTableName(Method targetMethod, Object[] methodArgs, DynamicTableName dynamicTableName) {
        if (methodArgs == null || methodArgs.length == 0) {
            return TableNameExtraInfo.empty();
        }
        final String prefix = dynamicTableName.prefix();
        final String suffix = dynamicTableName.suffix();
        String prefixResult = SpelUtil.parseSpel(targetMethod, methodArgs, prefix, String.class, "");
        String suffixResult = SpelUtil.parseSpel(targetMethod, methodArgs, suffix, String.class, "");
        return TableNameExtraInfo.of(prefixResult, suffixResult);
    }
}
