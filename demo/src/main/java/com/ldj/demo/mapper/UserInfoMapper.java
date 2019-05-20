package com.ldj.demo.mapper;

import com.ldj.demo.common.base.mapper.BaseMapper;
import com.ldj.demo.domain.UserInfo;

import java.util.List;
import java.util.Map;
/**
 * @author ldj
 * @date 2019/4/26 10:46
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    /**
     * 条件查询返回List
     * @param map
     * @return
     */
    public List findUserList1(Map<String, Object> map);

    /**
     * 查询是否已经注册
     * @param name
     * @return
     */
    public int findUser01(String name);
}
