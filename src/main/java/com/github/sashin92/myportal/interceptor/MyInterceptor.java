package com.github.sashin92.myportal.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor::preHandle");
		return true;
//		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor::postHandle");

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			String controllerName = handlerMethod.getBeanType().getName();
			String methodName = handlerMethod.getMethod().getName();
			
			logger.debug("Controller: " + controllerName + ", Method: " + methodName);
		}
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor::afterCompletion");
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
