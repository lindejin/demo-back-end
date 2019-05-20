package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.OrderInfo;

import java.util.List;

public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    public int updateOrder(List<Long> longs);
}