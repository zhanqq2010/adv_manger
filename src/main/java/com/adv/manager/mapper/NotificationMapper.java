package com.adv.manager.mapper;

import com.adv.manager.po.Notification;

public interface NotificationMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Notification record);

    int insertSelective(Notification record);

    Notification selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Notification record);

    int updateByPrimaryKeyWithBLOBs(Notification record);

    int updateByPrimaryKey(Notification record);
}