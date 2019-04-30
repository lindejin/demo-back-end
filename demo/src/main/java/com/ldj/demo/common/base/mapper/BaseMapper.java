package com.ldj.demo.common.base.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;
public interface BaseMapper<T> extends Mapper<T>, InsertListMapper<T>, ConditionMapper<T> {

}
