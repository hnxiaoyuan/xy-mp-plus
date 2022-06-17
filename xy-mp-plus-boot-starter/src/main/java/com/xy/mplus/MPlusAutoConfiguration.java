package com.xy.mplus;

import com.xy.mplus.configuration.DynamicTableAopConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xiaoyuan
 * @date 2022-04-16
 */
@Configuration
@Import({DynamicTableAopConfig.class})
public class MPlusAutoConfiguration {

}
