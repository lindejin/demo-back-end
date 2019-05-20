package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.AddressInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AddressInfoMapper extends BaseMapper<AddressInfo> {
    public List findAddressList01(Map<String, Object> map);
}
