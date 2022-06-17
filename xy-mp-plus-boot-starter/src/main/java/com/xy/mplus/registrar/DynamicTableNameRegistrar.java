package com.xy.mplus.registrar;

import com.xy.mplus.annotation.EnableMPlus;
import com.xy.mplus.configuration.DynamicTableNameAspectConfig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author xiaoyuan
 * @date 2022-04-16
 */
public class DynamicTableNameRegistrar implements ImportBeanDefinitionRegistrar {
    private static final Class<?> beanClass = DynamicTableNameAspectConfig.class;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        final String className = importingClassMetadata.getClassName();
        final Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableMPlus.class.getName());
        if (annotationAttributes == null) {
            return;
        }
        String expression = (String) annotationAttributes.get("expression");
        if (StringUtils.isEmpty(expression)) {
            String[] basePackages = (String[]) annotationAttributes.get("basePackages");
            if (basePackages == null || basePackages.length == 0) {
                basePackages = new String[]{getPackageName(className)};
            }
            expression = buildExpression(basePackages);
        }
        if (!registry.containsBeanDefinition(beanClass.getName())) {
            final BeanDefinition beanDefinition = BeanDefinitionBuilder
                    .rootBeanDefinition(beanClass)
                    .addConstructorArgValue(expression)
                    .getBeanDefinition();
            registry.registerBeanDefinition(beanClass.getName(), beanDefinition);
        }

        System.out.println(beanClass);
    }

    private String buildExpression(String[] basePackages) {
        // within(com.xyz.service..*) || within(com.xyz.service..*)
        StringBuilder builder = new StringBuilder();
        for (String basePackage : basePackages) {
            if (builder.length() > 0) {
                builder.append("||");
            }
            builder.append("within(");
            builder.append(basePackage);
            builder.append("..*)");
        }
        return "(" +
                "target(com.baomidou.mybatisplus.core.mapper.BaseMapper)||target(com.baomidou.mybatisplus.extension.service.IService)" +
                ")" +
                "&&" +
                "(" +
                builder.toString() +
                ")";
    }

    private String getPackageName(String className) {
        return className.substring(0, className.lastIndexOf("."));
    }

}
