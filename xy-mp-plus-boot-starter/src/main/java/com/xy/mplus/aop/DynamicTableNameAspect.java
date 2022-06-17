package com.xy.mplus.aop;

import com.xy.mplus.core.annotation.DynamicTableName;
import com.xy.mplus.core.annotation.DynamicTableNameStrategy;
import com.xy.mplus.util.DynamicTableNameHelper;
import com.xy.mplus.domain.TableNameExtraInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;

/**
 * 动态表名的AOP切面
 *
 * @author xiaoyuan
 * @date 2022-04-07
 */
@Aspect
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DynamicTableNameAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicTableNameAspect.class);

    /**
     * 切入mybatis-plus的mapper和service
     */
    @Pointcut("target(com.baomidou.mybatisplus.core.mapper.BaseMapper) || target(com.baomidou.mybatisplus.extension.service.IService)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        final Signature signature = joinPoint.getSignature();
        final Object[] args = joinPoint.getArgs();
        if (!(signature instanceof MethodSignature)) {
            return joinPoint.proceed(args);
        }
        //如果方法上有注解就优先使用方法上的注解
        final Method method = ((MethodSignature) signature).getMethod();
        DynamicTableName methodAnnotation = AnnotatedElementUtils.findMergedAnnotation(method, DynamicTableName.class);
        DynamicTableName dynamicTableNameAnnotation = methodAnnotation;
        if (methodAnnotation == null) {
            //类上的注解
            DynamicTableName classAnnotation = AnnotatedElementUtils.findMergedAnnotation(joinPoint.getTarget().getClass(), DynamicTableName.class);
            if (classAnnotation == null) {
                //类上也没有注解,直接执行
                return joinPoint.proceed(args);
            }
            dynamicTableNameAnnotation = classAnnotation;
        }
        final Class<? extends DynamicTableNameStrategy> strategy = dynamicTableNameAnnotation.strategy();
        final TableNameExtraInfo tableNameExtraInfo = strategy.newInstance().handleDynamicTableName(method, args, dynamicTableNameAnnotation);
        final String prefix = tableNameExtraInfo.getPrefix();
        final String suffix = tableNameExtraInfo.getSuffix();
        logger.info("进入动态表名切面, prefix:{}, suffix:{}", prefix, suffix);
        Object processResult = DynamicTableNameHelper.callWithDynamicTableName(tableNameExtraInfo, () -> {
            try {
                return joinPoint.proceed(args);
            } catch (Throwable throwable) {
                throw new RuntimeException(throwable);
            }
        });
        logger.info("退出动态表名切面, prefix:{}, suffix:{}", prefix, suffix);
        return processResult;
    }
}