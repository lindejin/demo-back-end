package com.ldj.demo.service.impl;

import com.ldj.demo.domain.AddressInfo;
import com.ldj.demo.mapper.AddressInfoMapper;
import com.ldj.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired(required=false)
    private AddressInfoMapper addressInfoMapper;







    /**
     *
     * 功能描述: 录入用户地址
     *
     * @param: []
     * @return: int
     * @auther: ldj
     * @date: 2019/4/19 15:05
     */
    @Override
    public int saveAddress() {

        return 0;
    }
    /**
     *
     * 功能描述:获取用户地址
     *
     * @param: [addressInfo]
     * @return: com.ldj.demo.domain.AddressInfo
     * @auther: ldj
     * @date: 2019/4/19 15:26
     */
    @Override
    public AddressInfo findAddress(AddressInfo addressInfo){

        return addressInfo;
    }
}
