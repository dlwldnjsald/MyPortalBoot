package com.github.sashin92.myportal.service;

import java.util.List;

import com.github.sashin92.myportal.data.vo.BoardVO;
import com.github.sashin92.myportal.data.vo.FileVO;


public interface BoardService {
	public List<BoardVO> getList();
	public BoardVO getContent(Integer no);
	public boolean write(BoardVO boardVO);
	public boolean update(BoardVO boardVO);
	
	public void increasementHitCount(Integer no);

	public boolean delete(Integer no, Integer userNo);
	
	public FileVO getFileRelatedByBoard(Integer boardNo);
}

