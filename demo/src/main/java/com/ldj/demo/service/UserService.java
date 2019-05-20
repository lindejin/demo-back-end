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



    /**获取单个用户信息
     * @param userInfo
     * @return
     */
    public UserInfo getUser(UserInfo userInfo);

    /**
     * 获取用户信息列表(未完成条件查询)
     * @param pageNumber
     * @param pageSize
     * @return PageInfo
     */
    public PageInfo<UserInfo> findUsers(int pageNumber,int pageSize);
    public List<UserInfo> getUsers();
    public List<UserInfo> finUser();
    public Map<String, Object> queryUser(Integer uerid);
    public List<Map<String,Object>> getMapQueryUsers();

    /**
     * 新增用户信息
     * @param userInfo
     * @return int
     */
    public int saveUser(UserInfo userInfo);

    /**
     * 更新用户信息
     * @param userInfo
     * @return int
     */
    public int modifyUser(UserInfo userInfo);

    /**
     * 注销用户信息，逻辑删除
     * @param userInfo
     * @return int
     */
    public int removeUser(UserInfo userInfo);
    public PageInfo<UserInfo> findUserList1(Map<String,Object> map);
    /**
     * 查询是否已经注册
     * @param name
     * @return
     */
    public int findUser01(String name);
}
