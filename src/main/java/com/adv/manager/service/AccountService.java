package com.adv.manager.service;

import java.util.List;

import com.adv.manager.po.Account;

public interface AccountService {

	Account getAccountByUsername(String username) throws Exception;

	void saveUser(Account account) throws Exception;

	void updateUserByUsername(String username, Account account)throws Exception;

	List<Account> getAccounts();

}
