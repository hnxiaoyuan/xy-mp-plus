package com.xy.mplus.configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.xy.mplus.context.DynamicTableNameContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @author Xiaoyuan
 */
@Configuration
public class MybatisPlusConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 动态表名插件
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor = new DynamicTableNameInnerInterceptor();
        dynamicTableNameInnerInterceptor.setTableNameHandler((sql, tableName) -> {
            final StringBuilder dynamicTableName = new StringBuilder();
            String prefix = DynamicTableNameContext.getPrefix();
            String suffix = DynamicTableNameContext.getSuffix();
            if (StringUtils.isNotBlank(prefix)) {
                //这里判断表名的前缀和后缀都不能有空白字符,防止sql注入,因为前缀和后缀都是直接拼在sql中的
                Assert.isTrue(!StringUtils.containsWhitespace(prefix), "invalid prefix:" + prefix);
                dynamicTableName.append(prefix).append(".");
            }
            dynamicTableName.append(tableName);
            if (StringUtils.isNotBlank(suffix)) {
                //这里判断表名的前缀和后缀都不能有空白字符
                Assert.isTrue(!StringUtils.containsWhitespace(suffix), "invalid suffix:" + suffix);
                dynamicTableName.append(suffix);
            }
            return dynamicTableName.toString();
        });
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);
        return interceptor;
    }
}
