package com.github.sashin92.myportal.data.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.sashin92.myportal.data.vo.UserVO;

@Mapper
public interface UserDAO {
	@Insert("INSERT INTO users(name, password, email, gender)\r\n"
			+ "    VALUES(#{name}, #{password}, #{email}, #{gender})")
	public int insert(UserVO vo);
	
	@Select("SELECT no, name, email, gender\r\n"
			+ "    FROM users\r\n"
			+ "    WHERE email=#{value}")
	public UserVO selectUser(String email);
	
	@Select("SELECT no, name, email, gender\r\n"
			+ "    FROM users\r\n"
			+ "    WHERE email = #{email} AND password = #{password}")
	public UserVO selectUserWithPassword(String email, String password);
}
