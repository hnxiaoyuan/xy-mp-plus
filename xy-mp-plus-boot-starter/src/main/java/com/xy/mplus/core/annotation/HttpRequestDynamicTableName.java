package com.xy.mplus.core.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@DynamicTableName(strategy = HttpRequestDynamicTableNameStrategy.class)
public @interface HttpRequestDynamicTableName {

    /**
     * 动态表名的前缀
     */
    @AliasFor(annotation = DynamicTableName.class)
    String prefix() default "";

    /**
     * 动态表名的后缀
     */
    @AliasFor(annotation = DynamicTableName.class)
    String suffix() default "";
}
