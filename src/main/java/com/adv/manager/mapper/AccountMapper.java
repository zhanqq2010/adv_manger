package com.adv.manager.mapper;

import com.adv.manager.po.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(String username);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}