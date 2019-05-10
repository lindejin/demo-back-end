package com.ldj.demo.service;

import com.ldj.demo.domain.UserInfo;

/**
 * @author ldj
 * @date 2019/4/19 11:26
 */
public interface AdminService {
    /**
     * 新增管理员信息
     * @param userInfo
     * @return
     */
    public int saveAdmin(UserInfo userInfo);
    /**
     * 更新管理员信息
     * @param userInfo
     * @return int
     */
    public int modifyAdmin(UserInfo userInfo);

    /**
     * 注销管理员信息，逻辑删除
     * @param userInfo
     * @return int
     */
    public int removeAdmin(UserInfo userInfo);
}
