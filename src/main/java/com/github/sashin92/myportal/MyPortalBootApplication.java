package com.github.sashin92.myportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MyPortalBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPortalBootApplication.class, args);
	}

}
