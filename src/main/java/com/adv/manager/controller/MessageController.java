package com.adv.manager.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.adv.manager.util.Config;
import com.adv.manager.xmpp.push.NotificationManager;

@Controller
@RequestMapping("message")
public class MessageController {
	
	@RequestMapping("/notification")
	public String notification() throws Exception {
        return "message/notification";
    }
	
	@RequestMapping("/sentNotification")
	 public ModelAndView sentNotification(HttpServletRequest request,
	            HttpServletResponse response) throws Exception {
	        String broadcast = ServletRequestUtils.getStringParameter(request,
	                "broadcast", "Y");
	        String username = ServletRequestUtils.getStringParameter(request,
	                "username");
	        String title = ServletRequestUtils.getStringParameter(request, "title");
	        String message = ServletRequestUtils.getStringParameter(request,
	                "message");
	        String uri = ServletRequestUtils.getStringParameter(request, "uri");
	        String mode = ServletRequestUtils.getStringParameter(request, "mode");
	        String imgUrl = ServletRequestUtils.getStringParameter(request, "imgUrl");

	        String apiKey = Config.getString("apiKey", "");
//	        logger.debug("apiKey=" + apiKey);
	        NotificationManager notificationManager = new NotificationManager();
	        if (broadcast.equalsIgnoreCase("Y")) {
	            notificationManager.sendBroadcast(apiKey, title, message, uri, imgUrl,mode);
	        } else {
	            notificationManager.sendNotifcationToUser(apiKey, username, title,
	                    message, uri, imgUrl, mode,true);
	        }

	        ModelAndView mav = new ModelAndView();
	        mav.setViewName("redirect:notification.do");
	        return mav;
	    }
}
