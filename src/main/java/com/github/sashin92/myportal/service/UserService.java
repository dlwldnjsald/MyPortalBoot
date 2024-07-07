package com.github.sashin92.myportal.service;

import com.github.sashin92.myportal.data.vo.UserVO;
import com.github.sashin92.myportal.exception.UserDAOException;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
	public boolean signUp(UserVO vo)  throws UserDAOException;
	public UserVO getUser(String email);
	public UserVO getUser(String email, String password);
	
	public boolean isAuthenticated(HttpServletRequest request);
	
}
