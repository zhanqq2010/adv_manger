package com.adv.manager.xmpp.handler;

import org.dom4j.Element;
import org.xmpp.packet.IQ;
import org.xmpp.packet.PacketError;

import com.adv.manager.service.NotificationService;
import com.adv.manager.service.ServiceLocator;
import com.adv.manager.xmpp.UnauthorizedException;
import com.adv.manager.xmpp.session.ClientSession;
import com.adv.manager.xmpp.session.Session;

public class IQDeliverConfirmHandler extends IQHandler{
	private static final String NAMESPACE = "androidpn:iq:deliverconfirm";
	
	private NotificationService notificationService;
	
	public IQDeliverConfirmHandler(){
		notificationService = ServiceLocator.getNotificationService();
	}
	@Override
	public IQ handleIQ(IQ packet) throws UnauthorizedException {
	    IQ reply = null;

        ClientSession session = sessionManager.getSession(packet.getFrom());
        if (session == null) {
            log.error("Session not found for key " + packet.getFrom());
            reply = IQ.createResultIQ(packet);
            reply.setChildElement(packet.getChildElement().createCopy());
            reply.setError(PacketError.Condition.internal_server_error);
            return reply;
        }
        
        if(session.getStatus() == Session.STATUS_AUTHENTICATED){
        	 if(IQ.Type.set.equals(packet.getType())){
        		 Element element = packet.getChildElement();
        		 String uuid = element.elementText("uuid");
        		 notificationService.deleteNotificationByUUID(uuid);
        	 }
        }
        return null;
	}

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

}
