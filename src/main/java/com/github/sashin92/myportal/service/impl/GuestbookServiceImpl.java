package com.github.sashin92.myportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sashin92.myportal.data.dao.GuestbookDAO;
import com.github.sashin92.myportal.data.vo.GuestbookVO;
import com.github.sashin92.myportal.service.GuestbookService;



@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	private GuestbookDAO guestbookDAO;
	
	@Override
	public List<GuestbookVO> getMessageList() {
		List<GuestbookVO> lst = guestbookDAO.selectAll();
		return lst;
	}

	@Override
	public boolean writeMessage(GuestbookVO vo) {
		
		int insertedCount = guestbookDAO.insert(vo);
		
		return insertedCount == 1;
	}

	@Override
	public boolean deleteMessage(GuestbookVO vo) {
		return guestbookDAO.delete(vo) == 1;
	}

	@Override
	public boolean updateMessage(GuestbookVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
