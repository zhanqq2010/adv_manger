package com.adv.manager.mapper;

import com.adv.manager.po.Partner;

public interface PartnerMapper {
    int deleteByPrimaryKey(String username);

    int insert(Partner record);

    int insertSelective(Partner record);

    Partner selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(Partner record);

    int updateByPrimaryKeyWithBLOBs(Partner record);

    int updateByPrimaryKey(Partner record);
}