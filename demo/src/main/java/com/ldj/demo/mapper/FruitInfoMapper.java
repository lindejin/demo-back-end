package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.FruitInfo;

import java.util.List;
import java.util.Map;
/**
 * @author ldj
 * @date 2019/4/26 10:46
 */
public interface FruitInfoMapper extends BaseMapper<FruitInfo> {
    public List findFruitList01(Map<String, Object> map);
    public List findFruitList02(Map<String, Object> map);
}