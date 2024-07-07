package com.github.sashin92.myportal.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.sashin92.myportal.data.vo.GuestbookVO;

@Mapper
public interface GuestbookDAO {
	
	@Select("SELECT no, name, password, content, reg_date as regDate\r\n"
			+ "    FROM guestbook\r\n"
			+ "    ORDER BY regDate DESC")
	public List<GuestbookVO> selectAll();
	
	
	public GuestbookVO select(Long no);
	
	@Insert("INSERT INTO guestbook(name, password, content, reg_date)\r\n"
			+ "    VALUES(#{ name }, #{ password }, #{ content }, now())")
	public int insert(GuestbookVO vo);
	@Delete("DELETE FROM guestbook\r\n"
			+ "  WHERE no = #{no} AND password = #{password}")
	public int delete(GuestbookVO vo);
	public int update(GuestbookVO vo);
		
}
