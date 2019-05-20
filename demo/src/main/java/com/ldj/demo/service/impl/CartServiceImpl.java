package com.ldj.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.common.base.exception.BaseBusinessException;
import com.ldj.demo.domain.CartInfo;
import com.ldj.demo.domain.OrderDetailInfo;
import com.ldj.demo.domain.OrderInfo;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mapper.CartInfoMapper;
import com.ldj.demo.mapper.OrderDetailInfoMapper;
import com.ldj.demo.mapper.OrderInfoMapper;
import com.ldj.demo.service.CartService;
import com.ldj.demo.service.OrderDetailService;
import com.ldj.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired(required=false)
    private CartInfoMapper cartInfoMapper;
    @Autowired(required=false)
    private OrderInfoMapper orderInfoMapper;
    @Autowired(required=false)
    private OrderDetailInfoMapper orderDetailInfoMapper;
    @Override
    public int saveCartInfo(OrderDetailInfo orderDetailInfo) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // System.out.println(uuid);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(uuid);
        orderInfo.setUserId(orderDetailInfo.getUserId());
        orderInfo.setPaymentPrice(orderDetailInfo.getFruitTotalPrice());
        orderInfo.setOrderStatus("0");
        if((orderInfoMapper.insertSelective(orderInfo)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        orderDetailInfo.setOrderId(orderInfo.getOrderId());
        orderDetailInfo.setOrderNo(orderInfo.getOrderNo());

        if((orderDetailInfoMapper.insertSelective(orderDetailInfo)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        CartInfo cartInfo = new CartInfo();
        cartInfo.setUserId(orderInfo.getUserId());
        cartInfo.setOrderId(orderInfo.getOrderId());
        cartInfo.setCartStatus("0");
        cartInfo.setIsChecked(new Short("1"));
        System.out.println(cartInfo.toString());
        if((cartInfoMapper.insertSelective(cartInfo)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        return 1;
    }

    @Override
    public int modifyCartInfo(List<Long> longs) {
        // cartInfoMapper.updateCart(longs);
        if((cartInfoMapper.updateCart(longs)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        if((orderInfoMapper.updateOrder(longs)) == 0){
            throw new BaseBusinessException("抛出业务异常");
        }
        return 1;
    }

    @Override
    public int removeCartInfo(CartInfo cartInfo) {
        return cartInfoMapper.updateByPrimaryKeySelective(cartInfo);
    }

    @Override
    public PageInfo<Map<String, Object>> findCartInfo01(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<Map<String, Object>> list= cartInfoMapper.getCartMap(map);
        PageInfo<Map<String, Object>> personPageInfo = new PageInfo<>(list);
        //得到分页的结果对象

        return personPageInfo;
    }

    @Override
    public PageInfo<Map<String, Object>> findCartFruitMap(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<Map<String, Object>> list= cartInfoMapper.findCartFruitMap(map);
        PageInfo<Map<String, Object>> personPageInfo = new PageInfo<>(list);
        //得到分页的结果对象

        return personPageInfo;
    }
    @Override
    public PageInfo<Map<String, Object>> findCartFruitMap02(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<Map<String, Object>> list= cartInfoMapper.findCartFruitMap02(map);
        PageInfo<Map<String, Object>> personPageInfo = new PageInfo<>(list);
        //得到分页的结果对象

        return personPageInfo;
    }
    @Override
    public PageInfo<Map<String, Object>> findCartFruitMap03(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<Map<String, Object>> list= cartInfoMapper.findCartFruitMap03(map);
        PageInfo<Map<String, Object>> personPageInfo = new PageInfo<>(list);
        //得到分页的结果对象

        return personPageInfo;
    }

}
