package com.ja.freeboard.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.ja.freeboard.vo.BoardVo;

public interface BoardSQLMapper {
 
	public int creatKey();

	public void insert(BoardVo boardVo);
   
	public BoardVo selectByNo(int no);
	
	//5.13일 추가 페이징 총 게시물 갯수 처리
	public int selectAllCount();

	public int selectByTitleCount(String title);

	// List로 써서 다형성을 유지하자
	public List<BoardVo> selectAll(int currPage);
	
	//제목을 통한 페이지 찾기
	public List<BoardVo> selectByTitle(
			@Param("title")String title,
			@Param("currPage")int currPage);
	
	public void deleteByNo (int no);
    
	public void update(BoardVo boardVo);
	
	public void updateReadCount(int no);
}
