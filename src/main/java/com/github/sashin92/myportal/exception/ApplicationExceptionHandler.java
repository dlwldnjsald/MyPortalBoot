package com.github.sashin92.myportal.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		System.err.println("===================================");
		System.err.println("ControllerAdvice에 의한 ErrorHandling");
		e.printStackTrace();
		
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message", e.getMessage());
		
		return "errors/exception";
	}
}
