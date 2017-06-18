package com.adv.manager.mapper;

import com.adv.manager.po.ProductProject;

public interface ProductProjectMapper {
    int deleteByPrimaryKey(String pid);

    int insert(ProductProject record);

    int insertSelective(ProductProject record);

    ProductProject selectByPrimaryKey(String pid);

    int updateByPrimaryKeySelective(ProductProject record);

    int updateByPrimaryKey(ProductProject record);
}