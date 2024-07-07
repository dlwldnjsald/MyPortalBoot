package com.github.sashin92.myportal.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.github.sashin92.myportal.data.vo.BoardVO;

@Mapper
public interface BoardDAO {
	@Select("SELECT b.no,\r\n"
			+ "        b.title,\r\n"
			+ "        b.content,\r\n"
			+ "        b.hit,\r\n"
			+ "        b.reg_date as regDate,\r\n"
			+ "        b.user_no as userNo,\r\n"
			+ "        u.name as userName\r\n"
			+ "    FROM board b, users u\r\n"
			+ "    WHERE b.user_no = u.no")
	public List<BoardVO> selectAll();
	
	@Select("SELECT b.no,\r\n"
			+ "        b.title,\r\n"
			+ "        b.content,\r\n"
			+ "        b.hit,\r\n"
			+ "        b.reg_date as regDate,\r\n"
			+ "        b.user_no as userNo,\r\n"
			+ "        u.name as userName\r\n"
			+ "    FROM board b, users u\r\n"
			+ "    WHERE b.user_no = u.no AND b.no = #{val}")
	public BoardVO getContent(Integer no);
	
	@Insert("INSERT INTO board(title, content, user_no)\r\n"
			+ "    VALUES(#{title}, #{content}, #{userNo})")
	@Options(useGeneratedKeys = true, keyProperty = "no")
	public int insert(BoardVO boardVO);
	
	@Update("UPDATE board\r\n"
			+ "    SET title = #{title}, content = #{content}\r\n"
			+ "    WHERE no = #{no}")
	public int update(BoardVO boardVO);
	
	@Update("UPDATE board\r\n"
			+ "    SET hit = hit + 1\r\n"
			+ "    WHERE no = #{val}")
	public int increaseHitCount(Integer no);
	
	@Delete("DELETE FROM board\r\n"
			+ "    WHERE no = #{no} AND user_no = #{userNo}")
	public int delete(Integer no, Integer userNo);
}