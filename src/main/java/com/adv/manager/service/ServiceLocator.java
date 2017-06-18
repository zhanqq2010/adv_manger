package com.adv.manager.service;


import com.adv.manager.xmpp.XmppServer;

/** 
 * This is a helper class to look up service objects.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class ServiceLocator {

    public static String USER_SERVICE = "userService";
    public static String NOTIFICATION_SERVICE = "notificationService";
    public static String PARTNER_SERVICE = "partnerService";

    /**
     * Generic method to obtain a service object for a given name. 
     * 
     * @param name the service bean name
     * @return
     */
    public static Object getService(String name) {
        return XmppServer.getInstance().getBean(name);
    }

    /**
     * Obtains the user service.
     * 
     * @return the user service
     */
    public static AccountService getAccountService() {
        return (AccountService) XmppServer.getInstance().getBean(USER_SERVICE);
    }
    /**
     * Obtains the notification service.
     * 
     * @return the notification service
     */
    public static NotificationService getNotificationService() {
    	return (NotificationService) XmppServer.getInstance().getBean(NOTIFICATION_SERVICE);
    }
    /**
     * Obtains the notification service.
     * 
     * @return the notification service
     */
    public static PartnerService getPartnerService() {
    	return (PartnerService) XmppServer.getInstance().getBean(PARTNER_SERVICE);
    }

}
