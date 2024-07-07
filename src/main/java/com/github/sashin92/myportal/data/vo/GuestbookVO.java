package com.github.sashin92.myportal.data.vo;

import java.sql.Timestamp;

public class GuestbookVO {
	private Long no;
	private String name;
	private String password;
	private String content;
	private Timestamp regDate;
	
	public GuestbookVO() {
	}
	
	public GuestbookVO(Long no, String password) {
		this.no = no;
		this.password = password;
	}

	public GuestbookVO(Long no, String name, String content, Timestamp regDate) {
		this.no = no;
		this.name = name;
		this.content = content;
		this.regDate = regDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "GuestbookVO [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regDate=" + regDate + "]";
	}
	
}
