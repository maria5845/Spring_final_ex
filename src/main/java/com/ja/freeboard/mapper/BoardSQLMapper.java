package com.ja.freeboard.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ja.freeboard.vo.BoardVo;

public interface BoardSQLMapper {
 
	public void insert(BoardVo boardVo);
   
	public BoardVo selectByNo(int no);
	
	// List로 써서 다형성을 유지하자
	public List<BoardVo> selectAll();
	
	public void deleteByNo (int no);
    
	public void update(BoardVo boardVo);
	
	public void updateReadCount(int no);
}
