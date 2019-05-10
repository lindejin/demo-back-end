package com.ldj.demo.service.impl;

import com.ldj.demo.domain.OrderInfo;
import com.ldj.demo.mapper.OrderInfoMapper;
import com.ldj.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    public int saveOrder(OrderInfo orderInfo) {
        return orderInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public int modifyOrder(OrderInfo orderInfo) {
        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }

    @Override
    public int removeOrder(OrderInfo orderInfo) {
        return orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
    }
}
