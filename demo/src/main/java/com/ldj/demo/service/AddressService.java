package com.ldj.demo.service;

import com.ldj.demo.domain.AddressInfo;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface AddressService {
    /**
     *
     * 功能描述:
     *
     * @param: []
     * @return: int
     * @auther: ldj
     * @date: 2019/4/19 15:28
     */
    public int saveAddress();
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
}
