package com.ldj.demo.service.impl;

import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mapper.UserInfoMapper;
import com.ldj.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int saveAdmin(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int modifyAdmin(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int removeAdmin(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
