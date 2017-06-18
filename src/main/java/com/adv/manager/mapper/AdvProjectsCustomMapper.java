package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.AdvProject;
import com.adv.manager.po.ProductProject;

public interface AdvProjectsCustomMapper {
//	 List<ProductProject> queryProductProjectsByUsername(String username);
	 List<AdvProject> queryAdvProjects();

//	ProductProject selectByPid(String pid);
//
//	void delProductProjectByPid(String pid);
}