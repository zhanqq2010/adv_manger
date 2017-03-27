package com.adv.manager.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//获取请求的url
		String url = request.getRequestURI();
		//判断url是否是公�?地址（实际使用时将公�?地址配置配置文件中）
		//这里公开地址是登陆提交的地址
		String projectPath = request.getContextPath();  
		
		//把参数中�?20变成 字符�? "
//		url.replaceAll("%20", " ");
		
		
		if( url.startsWith(projectPath + "/user/login")
				|| url.startsWith(projectPath + "/project/uploadFile.action")
				|| url.startsWith(projectPath + "/project/downloadUrl")
			){
			//如果进行登陆提交，放�?
			return true;
		}
		//判断session
		HttpSession session  = request.getSession();
		//从session中取出用户身份信�?
		String username = (String) session.getAttribute("username");
		
		if(username != null){
			//身份存在，放�?
			return true;
		}
		
		//执行这里表示用户身份�?��认证，跳转登陆页�?
		request.getRequestDispatcher("/WEB-INF/jsp/common/login.jsp").forward(request, response);
		
		//return false表示拦截，不向下执行
		//return true表示放行
		return false;
	}

}
