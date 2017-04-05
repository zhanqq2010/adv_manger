package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.ChannelProject;

public interface ChannelProjectsCustomMapper {

    List<ChannelProject> queryChannelProjectByUsername(String username);

}