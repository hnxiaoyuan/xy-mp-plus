package com.xy.mplus.core.annotation;

import com.xy.mplus.domain.TableNameExtraInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 通过HttpRequest获取表名的前后缀
 * @author xiaoyuan
 * @date 2022-04-08
 */
public class HttpRequestDynamicTableNameStrategy implements DynamicTableNameStrategy {
    @Override
    public TableNameExtraInfo handleDynamicTableName(Method targetMethod, Object[] methodArgs, DynamicTableName dynamicTableName) {
        final String prefix = dynamicTableName.prefix();
        final String suffix = dynamicTableName.suffix();
        final HttpServletRequest contextRequest = getContextRequest();
        if (contextRequest != null) {
            final String header = contextRequest.getHeader(prefix);
            if (StringUtils.isEmpty(header)) {
                return TableNameExtraInfo.empty();
            }
            return TableNameExtraInfo.of(header, suffix);
        }
        return TableNameExtraInfo.empty();
    }

    private HttpServletRequest getContextRequest(){
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return null;
        }
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }
}
