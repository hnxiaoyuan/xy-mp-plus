package com.xy.mplus.configuration;

import com.xy.mplus.aop.DynamicTableNameAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xiaoyuan
 * @date 2022-04-16
 */
@Configuration
@Import(MybatisPlusConfiguration.class)
public class DynamicTableAopConfig {

    @Bean
    public DynamicTableNameAspect dynamicTableNameAspect(){
        return new DynamicTableNameAspect();
    }
}
