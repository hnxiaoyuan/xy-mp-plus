package com.xy.test.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.xy.mplus.context.DynamicTableNameContext;
import com.xy.mplus.domain.TableNameExtraInfo;
import com.xy.mplus.util.DynamicTableNameHelper;
import com.xy.test.model.PublishRecordPO;
import com.xy.test.service.PublishRecordService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Stack;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
@RestController
@RequestMapping("/aop")
public class PublishRecordController {

    @Resource
    PublishRecordService publishRecordService;

    @RequestMapping("/invoke")
    public Object invoke(){
        HttpServletRequest request;
        final List<PublishRecordPO> list = publishRecordService.list();
        final Stack<TableNameExtraInfo> contextStack1 = DynamicTableNameContext.getContextStack();
        final Object list1 = publishRecordService.getList("459753");
        final Stack<TableNameExtraInfo> contextStack = DynamicTableNameContext.getContextStack();

        new Thread(() -> {
            System.out.println("===111子线程前:"+DynamicTableNameContext.getPrefix());
            DynamicTableNameHelper.runWithTableNamePrefix("b6653711", () -> {
                System.out.println("===222子线程前:"+DynamicTableNameContext.getPrefix());
            });
        }).start();
        return list1;
    }
}
