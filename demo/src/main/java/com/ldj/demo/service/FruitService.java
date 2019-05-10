package com.ldj.demo.service;

import com.ldj.demo.domain.FruitInfo;

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
}
