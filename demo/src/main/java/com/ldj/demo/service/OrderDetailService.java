package com.ldj.demo.service;

import com.ldj.demo.domain.OrderDetailInfo;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface OrderDetailService {
    /**
     * 新增订单详情
     * @param orderDetailInfo
     * @return
     */
    public int saveOrderDetail(OrderDetailInfo orderDetailInfo);

    /**
     * 更新订单详情
     * @param orderDetailInfo
     * @return
     */
    public int modifyOrderDetail(OrderDetailInfo orderDetailInfo);

    /**
     * 逻辑删除订单详情
     * @param orderDetailInfo
     * @return
     */
    public int removeOrderDetail(OrderDetailInfo orderDetailInfo);
}
