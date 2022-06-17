package com.xy.test;

import com.xy.mplus.annotation.EnableMPlus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Xiaoyuan
 */
@SpringBootApplication
@MapperScan("com.xy.test.dao")
@EnableMPlus
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class XyMpPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyMpPlusApplication.class, args);
    }

}
