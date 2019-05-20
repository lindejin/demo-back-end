package com.ldj.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.AddressInfo;
import com.ldj.demo.mapper.AddressInfoMapper;
import com.ldj.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public int saveAddress(AddressInfo addressInfo) {
        return addressInfoMapper.insertSelective(addressInfo);
    }

    @Override
    public int modifyAddress(AddressInfo addressInfo) {
        return addressInfoMapper.updateByPrimaryKeySelective(addressInfo);
    }

    @Override
    public int removeAddress(AddressInfo addressInfo) {
        return addressInfoMapper.updateByPrimaryKeySelective(addressInfo);
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

    @Override
    public PageInfo<AddressInfo> findAddressList01(Map<String, Object> map) {
        PageHelper.startPage(Integer.parseInt(map.get("pageSize").toString()),Integer.parseInt(map.get("pageNumber").toString()));
        List<AddressInfo> personList = addressInfoMapper.findAddressList01(map);
        //得到分页的结果对象
        PageInfo<AddressInfo> personPageInfo = new PageInfo<>(personList);

        return personPageInfo;
    }
}
