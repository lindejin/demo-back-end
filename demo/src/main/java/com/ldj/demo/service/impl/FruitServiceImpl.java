package com.ldj.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.FruitInfo;
import com.ldj.demo.mapper.FruitInfoMapper;
import com.ldj.demo.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
@Service
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
    @Override
    public FruitInfo findFruit(FruitInfo fruitInfo) {
        return fruitInfoMapper.selectByPrimaryKey(fruitInfo);
    }
    @Override
    public PageInfo<FruitInfo> findFruit01(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<FruitInfo> personList = fruitInfoMapper.findFruitList01(map);
        //得到分页的结果对象
        PageInfo<FruitInfo> personPageInfo = new PageInfo<>(personList);

        return personPageInfo;
    }

    @Override
    public PageInfo<FruitInfo> findFruit02(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<FruitInfo> personList = fruitInfoMapper.findFruitList02(map);
        //得到分页的结果对象
        PageInfo<FruitInfo> personPageInfo = new PageInfo<>(personList);

        return personPageInfo;
    }


}
