package com.adv.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adv.manager.mapper.UserMapper;
import com.adv.manager.po.User;
import com.adv.manager.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper mapper;

	
	@Override
	public User findUserByUserName(String username) throws Exception {
		
		return mapper.selectByPrimaryKey(username);
	}


	@Override
	public boolean login(String username, String pwd) throws Exception {
		User user = findUserByUserName(username);
		if(user != null){
			if(user.getPassword().equals(pwd)){
				return true;
			}
		}
		return false;
	}

}
