package com.adv.manager.mapper;

import com.adv.manager.po.Country;

public interface CountryMapper {
    int deleteByPrimaryKey(String zhName);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(String zhName);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}