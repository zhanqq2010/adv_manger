package com.adv.manager.service;

import java.util.List;

import com.adv.manager.po.Notification;

public interface NotificationService {

	void deleteNotificationByUUID(String uuid);

	List<Notification> findNotificationsByUsername(String username);

	void deleteNotification(Notification notification);

	void saveNotification(Notification notification);

}
