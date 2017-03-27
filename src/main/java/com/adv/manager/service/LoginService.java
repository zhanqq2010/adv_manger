package com.adv.manager.service;

import com.adv.manager.po.User;


public interface LoginService {
	
	//查询用户
	public User findUserByUserName(String username) throws Exception;
	
	public boolean login(String username, String pwd) throws Exception;

}
