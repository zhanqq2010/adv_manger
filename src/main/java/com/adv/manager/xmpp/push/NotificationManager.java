/*
 * Copyright (C) 2010 Moduad Co., Ltd.
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package com.adv.manager.xmpp.push;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.xmpp.packet.IQ;

import com.adv.manager.po.Account;
import com.adv.manager.po.Notification;
import com.adv.manager.service.AccountService;
import com.adv.manager.service.NotificationService;
import com.adv.manager.util.Constant;
import com.adv.manager.xmpp.session.ClientSession;
import com.adv.manager.xmpp.session.SessionManager;

/** 
 * This class is to manage sending the notifcations to the users.  
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class NotificationManager {
	

    private static final String NOTIFICATION_NAMESPACE = "androidpn:iq:notification";

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    private NotificationService notificationService;
    private SessionManager sessionManager;
    @Autowired
    private AccountService accountService;
    
    
    

    /**
     * Constructor.
     */
    public NotificationManager() {
        sessionManager = SessionManager.getInstance();
    }

    /**
     * Broadcasts a newly created notification message to all connected users.
     * 
     * @param apiKey the API key
     * @param title the title
     * @param message the message details
     * @param uri the uri
     */
    public void sendBroadcast(String apiKey, String title, String message,  String uri, String imagUrl, String mode) {
        log.debug("sendBroadcast()...");
       
        List<Account> accounts = accountService.getAccounts();
        if(accounts != null && accounts.size() > 0){
            for(Account account : accounts){
            	ClientSession session = sessionManager.getSession(account.getUsername());
            	 String uuid = generateUUID();
                 IQ notificationIQ = createNotificationIQ(uuid,apiKey, title, message, uri, imagUrl, mode);
            	if(session != null && session.getPresence().isAvailable()){
            		notificationIQ.setTo(session.getAddress());
            		session.deliver(notificationIQ);
//            		saveNotification(id, apiKey, user.getUsername(), title, message, uri,mode);
            	}
            	saveNotification(uuid, apiKey, account.getUsername(), title, message, uri, imagUrl,mode);
            }
        }
 
 /*       for (ClientSession session : sessionManager.getSessions()) {
            if (session.getPresence().isAvailable()) {
                notificationIQ.setTo(session.getAddress());
                session.deliver(notificationIQ);
            }
        }*/
    }

    /**
     * Sends a newly created notification message to the specific user.
     * 
     * @param apiKey the API key
     * @param title the title
     * @param message the message details
     * @param uri the uri
     */
    public void sendNotifcationToUser(String apiKey, String username,
            String title, String message, String uri, String imagUrl, String mode, boolean shouldSave) {
        log.debug("sendNotifcationToUser()...");
        String id = generateUUID();
        IQ notificationIQ = createNotificationIQ(id, apiKey, title, message, uri, imagUrl, mode);
        ClientSession session = sessionManager.getSession(username);
        if (session != null && shouldSave) {
            if (session.getPresence().isAvailable()) {
                notificationIQ.setTo(session.getAddress());
                session.deliver(notificationIQ);
            }
        }
        
        try {
        	Account user = accountService.getAccountByUsername(username);
			if(user != null){
				saveNotification(id,apiKey, username, title, message, uri, imagUrl, mode);
        	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    private void sendPopWindow2All(String apiKey, String title, String message,
            String uri, String imagUrl,String mode) {
    	log.debug("sendPopWindow2All()...");
        
        List<Account> accounts;
		try {
			accounts = accountService.getAccounts();
			 for(Account account : accounts){
		        	ClientSession session = sessionManager.getSession(account.getUsername());
		        	 String id = generateUUID();
		             IQ notificationIQ = createNotificationIQ(id,apiKey, title, message, uri,imagUrl,Constant.NOTIFICATION_APK);
		        	if(session != null && session.getPresence().isAvailable()){
		        		notificationIQ.setTo(session.getAddress());
		        		session.deliver(notificationIQ);
		        		saveNotification(id, apiKey, account.getUsername(), title, message, uri, imagUrl, mode);
		        	}
		        	saveNotification(id, apiKey, account.getUsername(), title, message, uri,imagUrl, mode);
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }


    /**
     * Creates a new notification IQ and returns it.
     */
    private IQ createNotificationIQ(String uuid, String apiKey, String title,
            String message, String uri, String imgUrl,String mode) {
//        Random random = new Random();
//        String id = Integer.toHexString(random.nextInt());
        // String id = String.valueOf(System.currentTimeMillis());

        Element notification = DocumentHelper.createElement(QName.get(
                "notification", NOTIFICATION_NAMESPACE));
        notification.addElement("uuid").setText(uuid);
        notification.addElement("apiKey").setText(apiKey);
        notification.addElement("title").setText(title);
        notification.addElement("message").setText(message);
        notification.addElement("uri").setText(uri);
        notification.addElement("mode").setText(mode);
        notification.addElement("imgUrl").setText(imgUrl);

        IQ iq = new IQ();
        iq.setType(IQ.Type.set);
        iq.setChildElement(notification);

        return iq;
    }
    
    
    private void saveNotification(String uuid, String apiKey, String username,
            String title, String message, String uri, String imgUrl, String mode){
    	
    	Notification notification = new Notification();
    	notification.setApiKey(apiKey);
    	notification.setUsername(username);
    	notification.setTitle(title);
    	notification.setMessage(message);
    	notification.setUri(uri);
    	notification.setUuid(uuid);
    	notification.setMode(mode);
    	notification.setImgUrl(imgUrl);
    	notificationService.saveNotification(notification);
    }
    
    /**
     * 生成16位id
     * @return
     */
    public String generateId(){
        Random random = new Random();
        String id = Integer.toHexString(random.nextInt());
        return id;
    }
    /**
     * 生成32位id
     * @return
     */
    public String generateUUID(){
    	 /*UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13)  
                + str.substring(14, 18) + str.substring(19, 23)  
                + str.substring(24);  
        return temp;*/  
          
        return UUID.randomUUID().toString().replace("-", "");  
    }
    
}
