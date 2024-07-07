package com.github.sashin92.myportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.github.sashin92.myportal.interceptor.AuthInterceptor;
import com.github.sashin92.myportal.service.UserService;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private UserService userService;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/upload/**")
			.addResourceLocations("file:c:/tmp/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthInterceptor(userService))
			.addPathPatterns("/board/**")
			.excludePathPatterns("/board")
			.excludePathPatterns("/board/")
			.excludePathPatterns("/board/list");
	}
}
