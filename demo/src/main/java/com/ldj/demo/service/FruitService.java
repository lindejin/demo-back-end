package com.ldj.demo.service;

import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.FruitInfo;

import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface FruitService {
    /**
     * 新增水果信息
     * @param fruitInfo
     * @return
     */
    public int saveFruit(FruitInfo fruitInfo);

    /**
     * 更新水果信息
     * @param fruitInfo
     * @return
     */
    public int modifyFruit(FruitInfo fruitInfo);

    /**
     * 逻辑删除水果信息
     * @param fruitInfo
     * @return
     */
    public int removeFruit(FruitInfo fruitInfo);

    /**
     *
     * @param map
     * @return
     */
    public PageInfo<FruitInfo> findFruit01(Map<String,Object> map);

    /**
     *
     * @param map
     * @return
     */
    public PageInfo<FruitInfo> findFruit02(Map<String,Object> map);
    public FruitInfo findFruit(FruitInfo fruitInfo);
}
