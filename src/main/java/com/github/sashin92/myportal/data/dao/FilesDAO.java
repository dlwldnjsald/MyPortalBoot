package com.github.sashin92.myportal.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.sashin92.myportal.data.vo.FileVO;

@Mapper
public interface FilesDAO {
	
	@Select("SELECT no, name\r\n"
			+ "    FROM files")
	public List<FileVO> selectList();
	@Select("SELECT no, name\r\n"
			+ "    FROM files\r\n"
			+ "    WHERE no = #{no}")
	public FileVO selectOne(Integer no);
	@Select("SELECT no, name\r\n"
			+ "    FROM files\r\n"
			+ "    WHERE name = #{name}")
	public FileVO selectOneByName(String name);
	@Insert("INSERT INTO files(name)\r\n"
			+ "    VALUES(#{name})")
	public Integer insert(FileVO fileVO);
	@Delete("DELETE FROM files\r\n"
			+ "    WHERE no = #{no}")
	public Integer delete(FileVO fileVO);
}
