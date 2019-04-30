package com.ldj.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
/**
 * 用户模块，提供用户功能实现service接口
 */
public interface UserService {
    /**
     * @param userInfo
     * @return
     */
    public int getUser(UserInfo userInfo);
    public PageInfo<UserInfo> findUsers(int pageNumber,int pageSize);
    public List<UserInfo> getUsers();
    public List<UserInfo> finUser();
    public Map<String, Object> queryUser(Integer uerid);
    public List<Map<String,Object>> getMapQueryUsers();
}
