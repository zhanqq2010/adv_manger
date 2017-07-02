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
package com.adv.manager.xmpp.handler;

import java.util.Date;

import gnu.inet.encoding.Stringprep;
import gnu.inet.encoding.StringprepException;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.xmpp.packet.IQ;
import org.xmpp.packet.JID;
import org.xmpp.packet.PacketError;

import com.adv.manager.po.Account;
import com.adv.manager.service.AccountService;
import com.adv.manager.service.UserExistsException;
import com.adv.manager.service.UserNotFoundException;
import com.adv.manager.service.impl.AccountServiceImpl;
import com.adv.manager.xmpp.UnauthorizedException;
import com.adv.manager.xmpp.session.ClientSession;
import com.adv.manager.xmpp.session.Session;

/** 
 * This class is to handle the TYPE_IQ jabber:iq:register protocol.
 *
 * @author Sehwan Noh (devnoh@gmail.com)
 */
public class IQRegisterHandler extends IQHandler {

    private static final String NAMESPACE = "jabber:iq:register";


    private Element probeResponse;
    
	private AccountService accountService;

    /**
     * Constructor.
     */
    public IQRegisterHandler() {
    	accountService = new AccountServiceImpl();
        probeResponse = DocumentHelper.createElement(QName.get("query",
                NAMESPACE));
        probeResponse.addElement("username");
        probeResponse.addElement("password");
        probeResponse.addElement("email");
        probeResponse.addElement("name");
    }

    /**
     * Handles the received IQ packet.
     * 
     * @param packet the packet
     * @return the response to send back
     * @throws UnauthorizedException if the user is not authorized
     */
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

        if (IQ.Type.get.equals(packet.getType())) { 
            reply = IQ.createResultIQ(packet);
            if (session.getStatus() == Session.STATUS_AUTHENTICATED) {
                // TODO
            } else {
                reply.setTo((JID) null);
                reply.setChildElement(probeResponse.createCopy());
            }
        } else if (IQ.Type.set.equals(packet.getType())) {
            try {
                Element query = packet.getChildElement();
                if (query.element("remove") != null) {
                    if (session.getStatus() == Session.STATUS_AUTHENTICATED) {
                        // TODO
                    } else {
                        throw new UnauthorizedException();
                    }
                } else {
                    String username = query.elementText("username");
                    String password = query.elementText("password");
                    String email = query.elementText("email");
                    String name = query.elementText("name");

                    // Verify the username
                    if (username != null) {
                        Stringprep.nodeprep(username);
                    }

                    // Deny registration of users with no password
                    if (password == null || password.trim().length() == 0) {
                        reply = IQ.createResultIQ(packet);
                        reply.setChildElement(packet.getChildElement()
                                .createCopy());
                        reply.setError(PacketError.Condition.not_acceptable);
                        return reply;
                    }

                    if (email != null && email.matches("\\s*")) {
                        email = null;
                    }

                    if (name != null && name.matches("\\s*")) {
                        name = null;
                    }

                    Account account;
                    
                    
                    
//                    try {
                    	account = accountService.getAccountByUsername(username);
						if(account != null && password != null ){
							if(!password.equals(account.getPassword())){
								account.setPassword(password);
								accountService.updateUserByUsername(username, account); 
							}
                        }else{
                        	account = new Account();
    						account.setUsername(username);
    						account.setPassword(password);
    						account.setEmail(email);
    						account.setName(name);
    						account.setCreatedDate(new Date(System.currentTimeMillis()));
                            accountService.saveUser(account);
                        }
//					} catch (Exception e) {
//						log.error("error: " + e.getMessage());
//						account = new Account();
//						account.setUsername(username);
//						account.setPassword(password);
//						account.setEmail(email);
//						account.setName(name);
//                        accountService.saveUser(account);
//					}
                    
	/*				if (session.getStatus() == Session.STATUS_AUTHENTICATED) {
                        if(user != null && password != null && password.equals(user.getPassword())){
                        	userService.updateUserByUsername(username, user); 
                        }else{
                        	userService.saveUser(user);
                        }
                    } else {
                    	user = userService.getUserByUsername(session.getUsername());
                    	if(user == null){
                    		user = new User();
                            user.setUsername(username);
                            user.setPassword(password);
                            user.setEmail(email);
                            user.setName(name);
                            userService.saveUser(user);
                    	}else{
                    		 if( password != null && password.equals(user.getPassword())){
                             	userService.updateUserByUsername(username, user); 
                             }
                    	}
                    	
                    }
                    
					if(user != null){
						try {
							userService.saveUser(user);
						} catch (Exception e) {
							log.debug("error : " + e.getMessage());
							userService.updateUserByUsername(username, user); 
						}
					}*/
				

                    reply = IQ.createResultIQ(packet);
                }
            } catch (Exception ex) {
                log.error(ex);
                reply = IQ.createResultIQ(packet);
                reply.setChildElement(packet.getChildElement().createCopy());
                if (ex instanceof UserExistsException) {
                    reply.setError(PacketError.Condition.conflict);
                } else if (ex instanceof UserNotFoundException) {
                    reply.setError(PacketError.Condition.bad_request);
                } else if (ex instanceof StringprepException) {
                    reply.setError(PacketError.Condition.jid_malformed);
                } else if (ex instanceof IllegalArgumentException) {
                    reply.setError(PacketError.Condition.not_acceptable);
                } else {
                    reply.setError(PacketError.Condition.internal_server_error);
                }
            }
        }

        // Send the response directly to the session
        if (reply != null) {
            session.process(reply);
        }
        return null;
    }

    /**
     * Returns the namespace of the handler.
     * 
     * @return the namespace
     */
    public String getNamespace() {
        return NAMESPACE;
    }

}
