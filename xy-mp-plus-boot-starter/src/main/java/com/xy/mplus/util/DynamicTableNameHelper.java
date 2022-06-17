package com.xy.mplus.util;

import com.xy.mplus.context.DynamicTableNameContext;
import com.xy.mplus.domain.TableNameExtraInfo;

import java.util.concurrent.Callable;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
public class DynamicTableNameHelper {

    public static void runWithTableNamePrefix(String prefix, Runnable runnable) {
        final TableNameExtraInfo tableNameExtraInfo = TableNameExtraInfo.of(prefix, "");
        runWithDynamicTableName(tableNameExtraInfo, runnable);
    }

    public static <T> T callWithTableNamePrefix(String prefix, Callable<T> callable) throws Exception {
        final TableNameExtraInfo tableNameExtraInfo = TableNameExtraInfo.of(prefix, "");
        return callWithDynamicTableName(tableNameExtraInfo, callable);
    }

    public static void runWithDynamicTableName(TableNameExtraInfo tableNameExtraInfo, Runnable runnable) {
        DynamicTableNameContext.set(tableNameExtraInfo.getPrefix(), tableNameExtraInfo.getSuffix());
        try {
            runnable.run();
        } finally {
            DynamicTableNameContext.remove();
        }
    }

    public static <T> T callWithDynamicTableName(TableNameExtraInfo tableNameExtraInfo, Callable<T> callable) throws Exception {
        DynamicTableNameContext.set(tableNameExtraInfo.getPrefix(), tableNameExtraInfo.getSuffix());
        try {
            return callable.call();
        } finally {
            DynamicTableNameContext.remove();
        }
    }
}
