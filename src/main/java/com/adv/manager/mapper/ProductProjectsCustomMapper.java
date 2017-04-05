package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.ProductProject;

public interface ProductProjectsCustomMapper {
	 List<ProductProject> queryProductProjectsByUsername(String username);
}