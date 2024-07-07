package com.github.sashin92.myportal.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.sashin92.myportal.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);	
	private UserService userService;
	
	@Autowired
	public AuthInterceptor(UserService userService) {
		this.userService = userService;
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if (userService.isAuthenticated(request)) {
			logger.debug("인증된 사용자 입니다.");
			return true;
		}
		logger.debug("누구세요");
		response.sendRedirect(request.getContextPath() + "/users/login");
		return false;
		
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	
}
