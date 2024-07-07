package com.github.sashin92.myportal.data.vo;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserVO {
	private Long no;
	@NotEmpty
	@Length(min = 2, max = 8)
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Length(min = 3, max = 20)
	private String password;
	@NotNull
	private String gender;
	private Timestamp joinDate;
	
	public UserVO() {
	}

	public UserVO(String name, String email, String password, String gender) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Timestamp joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVO [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joinDate=" + joinDate + "]";
	}
	
}
