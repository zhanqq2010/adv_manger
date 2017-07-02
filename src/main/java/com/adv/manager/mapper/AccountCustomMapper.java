package com.adv.manager.mapper;

import java.util.List;

import com.adv.manager.po.Account;
import com.adv.manager.po.AdvProject;
import com.adv.manager.po.ProductProject;

public interface AccountCustomMapper {
//	 List<ProductProject> queryProductProjectsByUsername(String username);
	 List<Account> getAccounts();

//	ProductProject selectByPid(String pid);
//
//	void delProductProjectByPid(String pid);
}