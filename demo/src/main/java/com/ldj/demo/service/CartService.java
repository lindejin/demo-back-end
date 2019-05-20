package com.ldj.demo.service;

import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.CartInfo;
import com.ldj.demo.domain.OrderDetailInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface CartService {
    /**
     * 新增水果信息
     * @param orderDetailInfo
     * @return
     */
    public int saveCartInfo(OrderDetailInfo orderDetailInfo);

    /**
     * 更新水果信息
     * @param cartInfo
     * @return
     */
    public int modifyCartInfo(List<Long> longs);

    /**
     * 逻辑删除水果信息
     * @param cartInfo
     * @return
     */
    public int removeCartInfo(CartInfo cartInfo);

    /**
     *
     * @param map
     * @return
     */
//    public PageInfo<CartInfo> findCartInfo01(Map<String,Object> map);
//    public PageInfo<CartInfo> findCartInfo02(Map<String,Object> map);
    public PageInfo<Map<String, Object>> findCartInfo01(Map<String, Object> map);
    public PageInfo<Map<String, Object>> findCartFruitMap(Map<String, Object> map);
    public PageInfo<Map<String, Object>> findCartFruitMap02(Map<String, Object> map);
    public PageInfo<Map<String, Object>> findCartFruitMap03(Map<String, Object> map);
}
