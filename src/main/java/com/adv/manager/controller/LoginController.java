package com.adv.manager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adv.manager.service.LoginService;

@Controller
@RequestMapping("user")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping("/login")
	public String login(String username,String pwd,HttpSession session) throws Exception{
		//从session中取出用户身份信息
		if(session != null){
			String sessionUsername = (String) session.getAttribute("username");
			if(sessionUsername != null){
				return "home";
			}
		}
		if(loginService.login(username, pwd)){
			session.setAttribute("username", username);
			return "home";
		}
		return "common/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		// 清除session
		session.invalidate();
		return "common/login";
	}
}
