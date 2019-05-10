package com.ldj.demo.service.impl;

import com.ldj.demo.domain.FruitInfo;
import com.ldj.demo.mapper.FruitInfoMapper;
import com.ldj.demo.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitInfoMapper fruitInfoMapper;

    @Override
    public int saveFruit(FruitInfo fruitInfo) {
        return fruitInfoMapper.insertSelective(fruitInfo);
    }

    @Override
    public int modifyFruit(FruitInfo fruitInfo) {
        return fruitInfoMapper.updateByPrimaryKeySelective(fruitInfo);
    }

    @Override
    public int removeFruit(FruitInfo fruitInfo) {
        return fruitInfoMapper.updateByPrimaryKeySelective(fruitInfo);
    }
}
