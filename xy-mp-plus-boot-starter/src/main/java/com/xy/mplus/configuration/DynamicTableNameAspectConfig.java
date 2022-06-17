package com.xy.mplus.configuration;

import com.xy.mplus.core.annotation.DynamicTableName;
import com.xy.mplus.core.annotation.DynamicTableNameStrategy;
import com.xy.mplus.domain.TableNameExtraInfo;
import com.xy.mplus.util.DynamicTableNameHelper;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.reflect.Method;

/**
 * @author xiaoyuan
 * @date 2022-04-16
 */
@Configuration
@Import(MybatisPlusConfiguration.class)
public class DynamicTableNameAspectConfig {

    private String pointcut;

    public DynamicTableNameAspectConfig(String pointcut) {
        this.pointcut = pointcut;
    }

    @Bean
    public AspectJExpressionPointcutAdvisor configurableAdvisor() {
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(pointcut);
        advisor.setAdvice(new DynamicTableNameAdvice());
        return advisor;
    }

    private static class DynamicTableNameAdvice implements MethodInterceptor {
        private static final Logger logger = LoggerFactory.getLogger(DynamicTableNameAdvice.class);

        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            final Method method = methodInvocation.getMethod();
            final DynamicTableName methodAnnotation = AnnotatedElementUtils.findMergedAnnotation(method, DynamicTableName.class);
            DynamicTableName dynamicTableNameAnnotation = methodAnnotation;
            if (methodAnnotation == null) {
                DynamicTableName classAnnotation = AnnotatedElementUtils.findMergedAnnotation(methodInvocation.getThis().getClass(), DynamicTableName.class);
                if (classAnnotation == null) {
                    return methodInvocation.proceed();
                }
                dynamicTableNameAnnotation = classAnnotation;
            }
            final Class<? extends DynamicTableNameStrategy> strategy = dynamicTableNameAnnotation.strategy();
            final TableNameExtraInfo tableNameExtraInfo = strategy.newInstance().handleDynamicTableName(method, methodInvocation.getArguments(), dynamicTableNameAnnotation);
            final String prefix = tableNameExtraInfo.getPrefix();
            final String suffix = tableNameExtraInfo.getSuffix();
            logger.info("进入动态表名切面, prefix:{}, suffix:{}", prefix, suffix);
            Object processResult = DynamicTableNameHelper.callWithDynamicTableName(tableNameExtraInfo, () -> {
                try {
                    return methodInvocation.proceed();
                } catch (Throwable throwable) {
                    throw new RuntimeException(throwable);
                }
            });
            logger.info("退出动态表名切面, prefix:{}, suffix:{}", prefix, suffix);
            return processResult;
        }
    }
}
