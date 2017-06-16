package com.adv.manager.mapper;

import com.adv.manager.po.ChannelProject;

public interface ChannelProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelProject record);

    int insertSelective(ChannelProject record);

    ChannelProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelProject record);

    int updateByPrimaryKey(ChannelProject record);
}