package com.github.sashin92.myportal.exception;

import com.github.sashin92.myportal.data.vo.GuestbookVO;

public class GuestbookDAOException extends RuntimeException {
	private GuestbookVO vo = null;
	
	
	public GuestbookDAOException() {
		super("SQL Exception caused by Guestbook accession");
	}

	public GuestbookDAOException(String message) {
		super(message);
	}

	public GuestbookDAOException(String message, GuestbookVO vo) {
		super(message);
		this.vo = vo;
	}

	public GuestbookVO getVo() {
		return vo;
	}

	
}
