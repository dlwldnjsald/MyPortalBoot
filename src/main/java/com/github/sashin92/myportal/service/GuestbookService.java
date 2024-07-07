package com.github.sashin92.myportal.service;

import java.util.List;

import com.github.sashin92.myportal.data.vo.GuestbookVO;


public interface GuestbookService {
	public List<GuestbookVO> getMessageList();

	public boolean writeMessage(GuestbookVO vo);
	public boolean deleteMessage(GuestbookVO vo);
	public boolean updateMessage(GuestbookVO vo);
}
