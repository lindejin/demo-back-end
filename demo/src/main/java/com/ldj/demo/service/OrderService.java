package com.ldj.demo.service;

import com.ldj.demo.domain.OrderInfo;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface OrderService {
    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    public int saveOrder(OrderInfo orderInfo);

    /**
     * 修改订单信息(比如 结算时间什么的)
     * @param orderInfo
     * @return
     */
    public int modifyOrder(OrderInfo orderInfo);

    /**
     * 逻辑删除订单信息
     * @param orderInfo
     * @return
     */
    public int removeOrder(OrderInfo orderInfo);
}
