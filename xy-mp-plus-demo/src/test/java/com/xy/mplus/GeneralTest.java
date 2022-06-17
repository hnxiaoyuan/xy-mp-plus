package com.xy.mplus;

import com.googlecode.aviator.AviatorEvaluator;

import com.xy.mplus.core.annotation.DynamicTableName;
import com.xy.test.service.impl.PublishRecordServiceImpl;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.apache.commons.jexl3.internal.Engine;
import org.assertj.core.util.Maps;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Map;

/**
 * @author xiaoyuan
 * @date 2022-04-12
 */
public class GeneralTest {

    @Test
    public void testAviator(){
        String expressRegx = "string.contains(name, '我要疯了') && !string.contains(name, '坚持一下')";
        final Map<String, Object> variables = Maps.newHashMap("name", "我坚持要疯了");
        Object result = AviatorEvaluator.execute(expressRegx, variables);
        System.out.println(result);
    }

    @Test
    public void testJexl(){
        String expressRegx = "name.contains('我要疯了')&&(!name.contains('坚持一下'))";
        final JexlExpression expression = new Engine().createExpression(expressRegx);
        JexlContext variables = new MapContext();
        variables.set("name", "傻逼二");
        final Object result = expression.evaluate(variables);
        System.out.println(result);

    }

    @Test
    public void testAnnotation(){
        final DynamicTableName mergedAnnotation = AnnotatedElementUtils.findMergedAnnotation(PublishRecordServiceImpl.class, DynamicTableName.class);
        System.out.println(mergedAnnotation);
    }

}
