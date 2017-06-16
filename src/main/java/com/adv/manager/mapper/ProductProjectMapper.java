package com.adv.manager.mapper;

import com.adv.manager.po.ProductProject;

public interface ProductProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductProject record);

    int insertSelective(ProductProject record);

    ProductProject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductProject record);

    int updateByPrimaryKey(ProductProject record);
}