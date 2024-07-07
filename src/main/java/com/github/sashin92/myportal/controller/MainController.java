package com.github.sashin92.myportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.sashin92.myportal.exception.MainControllerException;


@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	
	
	@RequestMapping("/")
	public String myportal() {
//		logger.debug("visited something.... who?");
		
		return "home";
	}
	
	@GetMapping("/except")
	public String raiseExcept() throws MainControllerException {
		throw new MainControllerException();
	}
}
