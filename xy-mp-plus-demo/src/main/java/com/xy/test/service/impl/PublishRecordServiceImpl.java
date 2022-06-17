package com.xy.test.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xy.test.dao.BusinessMapper;
import com.xy.test.dao.PublishRecordMapper;
import com.xy.test.model.Business;
import com.xy.test.model.PublishRecordPO;
import com.xy.test.service.PublishRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoyuan
 * @date 2022-04-08
 */
@Service
public class PublishRecordServiceImpl extends ServiceImpl<PublishRecordMapper, PublishRecordPO> implements PublishRecordService {

    @Resource
    private BusinessMapper businessMapper;

    @Override
    public Object getList(String bizId) {
        final List<Business> businesses = businessMapper.selectList(Wrappers.lambdaQuery());
        final List<PublishRecordPO> publishRecordList = list();
        List<Object> listAll = new ArrayList<>();
        listAll.addAll(businesses);
        listAll.addAll(publishRecordList);
        final List<Business> businesses2 = businessMapper.selectList(Wrappers.lambdaQuery());
        listAll.addAll(businesses2);
        return listAll;
    }

    @Override
    public Object getItemOne(String bizId) {
        return null;
    }
}
