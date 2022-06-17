package com.xy.mplus.core.annotation;

import java.lang.annotation.*;

/**
 * @author xiaoyuan
 * @date 2022-04-07
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@DynamicTableName(strategy = FixedTableNameStrategy.class)
public @interface FixedTableName {

    /**
     * 动态表名的前缀
     */
    String prefix() default "";

    /**
     * 动态表名的后缀
     */
    String suffix() default "";
}
