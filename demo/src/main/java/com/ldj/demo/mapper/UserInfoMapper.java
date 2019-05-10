package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    public List findUserList1(Map<String, Object> map);
}
