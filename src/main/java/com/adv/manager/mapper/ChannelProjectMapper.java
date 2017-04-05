package com.adv.manager.mapper;

import com.adv.manager.po.ChannelProject;

public interface ChannelProjectMapper {
    int deleteByPrimaryKey(String pid);

    int insert(ChannelProject record);

    int insertSelective(ChannelProject record);

    ChannelProject selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(ChannelProject record);

    int updateByPrimaryKey(ChannelProject record);
}