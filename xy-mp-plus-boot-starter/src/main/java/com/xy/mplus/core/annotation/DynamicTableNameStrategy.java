package com.xy.mplus.core.annotation;

import com.xy.mplus.domain.TableNameExtraInfo;

import java.lang.reflect.Method;

/**
 * 动态表名获取的策略
 * @author xiaoyuan
 * @date 2022-04-07
 */
public interface DynamicTableNameStrategy {

    /**
     * 动态表名的前缀和后缀的获取策略
     * @param joinPoint 切面的信息
     * @param dynamicTableName 注解信息
     * @return 动态表名前后缀信息
     */
    default TableNameExtraInfo handleDynamicTableName(Method targetMethod, Object[] methodArgs, DynamicTableName dynamicTableName){
        //默认不添加任何前后缀
        return TableNameExtraInfo.empty();
    }

}
