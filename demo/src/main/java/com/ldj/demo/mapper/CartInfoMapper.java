package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.CartInfo;

import java.util.List;
import java.util.Map;

public interface CartInfoMapper extends BaseMapper<CartInfo> {
    public List<Map<String, Object>> getCartMap(Map<String, Object> map);
    public List<Map<String, Object>> findCartFruitMap(Map<String, Object> map);
    public int updateCart(List<Long> longs);
    public List<Map<String, Object>> findCartFruitMap02(Map<String, Object> map);
    public List<Map<String, Object>> findCartFruitMap03(Map<String, Object> map);
}