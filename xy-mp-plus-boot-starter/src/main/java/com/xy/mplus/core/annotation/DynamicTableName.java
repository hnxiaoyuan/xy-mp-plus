package com.xy.mplus.core.annotation;

import java.lang.annotation.*;

/**
 * 动态表名基础注解
 * @author xiaoyuan
 * @date 2022-04-07
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DynamicTableName {

    /**
     * 动态表名的前缀
     */
    String prefix() default "";

    /**
     * 动态表名的后缀
     */
    String suffix() default "";

    /**
     * 针对prefix和suffix的获取处理策略
     */
    Class<? extends DynamicTableNameStrategy> strategy() default DefaultDynamicTableNameStrategy.class;
}
