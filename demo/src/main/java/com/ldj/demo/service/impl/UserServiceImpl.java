package com.ldj.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ldj.demo.domain.UserInfo;
import com.ldj.demo.mapper.UserInfoMapper;
import com.ldj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ldj
 * @date 2019/4/19 11:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required=false)
    private UserInfoMapper userInfoMapper;
    @Override
    public int getUser(UserInfo userInfo) {
        PageHelper.startPage(1, 6);
        return userInfoMapper.selectCount(userInfo);
    }
    @Override
    public PageInfo<UserInfo> findUsers(int pageNumber,int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        List<UserInfo> personList = userInfoMapper.selectAll();
        //得到分页的结果对象
        PageInfo<UserInfo> personPageInfo = new PageInfo<>(personList);
        //得到分页中的person条目对象
        List<UserInfo> pageList = personPageInfo.getList();
        //System.out.println(pageList.toString());
        //将结果存入map进行传送
        Map<String,Object> map = new HashMap<>();
        map.put("pageInfo" , pageList);
        Page<UserInfo> ls = (Page)personList;
        return personPageInfo;
    }

    @Override
    public List<UserInfo> getUsers() {

        //正常
        Condition condition = new Condition(UserInfo.class);
        Condition.Criteria criteria = condition.createCriteria();
        criteria.andCondition("user_id like '%1%'");



        List<UserInfo> ls = userInfoMapper.selectByExample(condition);

        return ls;
       //有效
        /*Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId", "1");
        return userInfoMapper.selectByExample(example);*/

    }

    @Override
    public List<UserInfo> finUser() {
        return null;
    }

    @Override
    public Map<String, Object> queryUser(Integer uerid) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getMapQueryUsers() {
        return null;
    }

    @Override
    public int saveUser(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public int modifyUser(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public int removeUser(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
