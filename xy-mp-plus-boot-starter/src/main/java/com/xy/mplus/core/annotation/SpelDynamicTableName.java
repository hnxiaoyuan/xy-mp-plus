package com.xy.mplus.core.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * spel表达式获取动态表名的前后缀
 * @author xiaoyuan
 * @date 2022-04-07
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@DynamicTableName(strategy = SpelDynamicTableNameStrategy.class)
public @interface SpelDynamicTableName {

    /**
     * @see DynamicTableName#prefix()
     */
    @AliasFor(annotation = DynamicTableName.class)
    String prefix() default "";

    /**
     * @see DynamicTableName#suffix()
     */
    @AliasFor(annotation = DynamicTableName.class)
    String suffix() default "";


}
