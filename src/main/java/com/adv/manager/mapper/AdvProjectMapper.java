package com.adv.manager.mapper;

import com.adv.manager.po.AdvProject;

public interface AdvProjectMapper {
    int deleteByPrimaryKey(String pid);

    int insert(AdvProject record);

    int insertSelective(AdvProject record);

    AdvProject selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(AdvProject record);

    int updateByPrimaryKey(AdvProject record);
}