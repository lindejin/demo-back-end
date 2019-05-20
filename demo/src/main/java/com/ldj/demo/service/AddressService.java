package com.ldj.demo.service;

import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.AddressInfo;

import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface AddressService {
    /**
     *
     * 功能描述:新增收货地址信息
     *
     * @param: []
     * @return: int
     * @auther: ldj
     * @date: 2019/4/19 15:28
     */
    public int saveAddress(AddressInfo addressInfo);

    /**
     * 更新收货地址
     * @param addressInfo
     * @return
     */
    public int modifyAddress(AddressInfo addressInfo);

    /**
     * 逻辑删除收货地址
     * @param addressInfo
     * @return
     */
    public int removeAddress(AddressInfo addressInfo);
    /**
     *
     * 功能描述:
     *
     * @param: [addressInfo]
     * @return: com.ldj.demo.domain.AddressInfo
     * @auther: ldj
     * @date: 2019/4/19 15:51
     */
    public AddressInfo findAddress(AddressInfo addressInfo);
    /**
     *
     * @param map
     * @return
     */
    public PageInfo<AddressInfo> findAddressList01(Map<String,Object> map);
}
