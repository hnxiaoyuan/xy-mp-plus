package com.xy.mplus.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.xy.mplus.domain.TableNameExtraInfo;
import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * 动态表名的ThreadLocal上下文
 *
 * @author xiaoyuan
 * @date 2022-04-07
 */
public class DynamicTableNameContext {
    private final static ThreadLocal<Stack<TableNameExtraInfo>> DYNAMIC_TABLE_NAME_CONTEXT = TransmittableThreadLocal.withInitial(Stack::new);
    private final static String EMPTY = "";

    public static void set(String prefix, String suffix) {
        if (prefix == null) {
            prefix = EMPTY;
        }
        if (suffix == null) {
            suffix = EMPTY;
        }
        if (StringUtils.isEmpty(prefix) && StringUtils.isEmpty(suffix)) {
            return;
        }
        getContextStack().push(TableNameExtraInfo.of(prefix, suffix));
    }

    public static String getPrefix() {
        final Stack<TableNameExtraInfo> contextStack = getContextStack();
        if (contextStack.isEmpty()) {
            return EMPTY;
        }
        return contextStack.peek().getPrefix();
    }

    public static String getSuffix() {
        final Stack<TableNameExtraInfo> contextStack = getContextStack();
        if (contextStack.isEmpty()) {
            return EMPTY;
        }
        return contextStack.peek().getSuffix();
    }

    public static void remove() {
        if (!getContextStack().isEmpty()) {
            getContextStack().pop();
        }
        if (getContextStack().isEmpty()) {
            DYNAMIC_TABLE_NAME_CONTEXT.remove();
        }
    }

    public static Stack<TableNameExtraInfo> getContextStack() {
        return DYNAMIC_TABLE_NAME_CONTEXT.get();
    }
}
