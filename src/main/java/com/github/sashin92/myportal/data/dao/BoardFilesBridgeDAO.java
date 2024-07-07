package com.github.sashin92.myportal.data.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.sashin92.myportal.data.vo.BoardFilesBridgeVO;

@Mapper
public interface BoardFilesBridgeDAO {
	@Select("SELECT board_no as boardNo, file_no as fileNo\r\n"
			+ "    FROM board_files_bridge")
	public List<BoardFilesBridgeVO> selectList();
	
	@Select("SELECT board_no as boardNo, file_no as fileNo\r\n"
			+ "    FROM board_files_bridge\r\n"
			+ "    WHERE board_no = #{boardNo}")
	public BoardFilesBridgeVO selectOneByBoardNo(Integer boardNo);
	
	@Select("SELECT board_no as boardNo, file_no as fileNo\r\n"
			+ "    FROM board_files_bridge\r\n"
			+ "    WHERE fileNo = #{fileNo}")
	public BoardFilesBridgeVO selectOneByFileNo(Integer fileNo);
	
	@Insert("INSERT INTO board_files_bridge(board_no, file_no)\r\n"
			+ "    VALUES(#{boardNo}, #{fileNo})")
	public Integer insert(BoardFilesBridgeVO vo);
	
	@Delete("DELETE FROM board_files_bridge\r\n"
			+ "    WHERE board_no = #{boardNo} OR file_no = #{fileNo}")
	public Integer delete(BoardFilesBridgeVO vo);
}
