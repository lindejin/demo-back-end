package com.ldj.demo.service.impl;

import com.ldj.demo.domain.OrderDetailInfo;
import com.ldj.demo.mapper.OrderDetailInfoMapper;
import com.ldj.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailInfoMapper orderDetailInfoMapper;

    @Override
    public int saveOrderDetail(OrderDetailInfo orderDetailInfo) {
        return orderDetailInfoMapper.insertSelective(orderDetailInfo);
    }

    @Override
    public int modifyOrderDetail(OrderDetailInfo orderDetailInfo) {
        return orderDetailInfoMapper.updateByPrimaryKeySelective(orderDetailInfo);
    }

    @Override
    public int removeOrderDetail(OrderDetailInfo orderDetailInfo) {
        return orderDetailInfoMapper.updateByPrimaryKeySelective(orderDetailInfo);
    }
}
