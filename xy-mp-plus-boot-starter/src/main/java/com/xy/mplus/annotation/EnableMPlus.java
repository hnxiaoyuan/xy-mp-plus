package com.xy.mplus.annotation;

import com.xy.mplus.MPlusAutoConfiguration;
import com.xy.mplus.registrar.DynamicTableNameRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;
import org.springframework.scheduling.annotation.EnableAsync;

import java.lang.annotation.*;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableAsync
//@Import(MPlusAutoConfiguration.class)
@Import({DynamicTableNameRegistrar.class})
public @interface EnableMPlus {

    @AliasFor("basePackages")
    String[] value() default {};

    @AliasFor("value")
    String[] basePackages() default {};

    String expression() default "target(com.baomidou.mybatisplus.core.mapper.BaseMapper) || target(com.baomidou.mybatisplus.extension.service.IService)";
}
