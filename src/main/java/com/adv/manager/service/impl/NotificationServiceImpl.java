package com.adv.manager.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.adv.manager.factory.sqlSessionFactoryUtil;
import com.adv.manager.mapper.AccountMapper;
import com.adv.manager.mapper.NotificationMapper;
import com.adv.manager.po.Notification;
import com.adv.manager.service.NotificationService;

public class NotificationServiceImpl implements NotificationService {

	@Autowired 
	private NotificationMapper notificationMapper;
	
	public NotificationServiceImpl(){
		SqlSessionFactory factory = sqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		notificationMapper = session.getMapper(NotificationMapper.class);
	}
	
	@Override
	public void deleteNotificationByUUID(String uuid) {
		notificationMapper.deleteByPrimaryKey(uuid);

	}

	@Override
	public List<Notification> findNotificationsByUsername(String username) {
		
		return null;
	}

	@Override
	public void deleteNotification(Notification notification) {
		notificationMapper.deleteByPrimaryKey(notification.getUuid());

	}

	@Override
	public void saveNotification(Notification notification) {
		notificationMapper.insert(notification);

	}

}
