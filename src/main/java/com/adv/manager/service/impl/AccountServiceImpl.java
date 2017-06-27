package com.adv.manager.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.adv.manager.factory.sqlSessionFactoryUtil;
import com.adv.manager.mapper.AccountMapper;
import com.adv.manager.po.Account;
import com.adv.manager.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	
	public AccountServiceImpl(){
		SqlSessionFactory factory = sqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		accountMapper = session.getMapper(AccountMapper.class);
	}
	@Override
	public Account getAccountByUsername(String username) throws Exception {
		return accountMapper.selectByPrimaryKey(username);
	}

	@Override
	public void saveUser(Account account) throws Exception {
		accountMapper.insert(account);

	}

	@Override
	public void updateUserByUsername(String username, Account account)
			throws Exception {
		account.setUsername(username);
		accountMapper.updateByPrimaryKey(account);

	}

	@Override
	public List<Account> getAccounts() {
		return null;
	}

}
