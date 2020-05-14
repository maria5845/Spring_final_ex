package com.ja.freeboard.mapper;

import java.util.List;

import com.ja.freeboard.vo.UploadFileVo;

public interface UploadFileSQLMapper {

	public void insert(UploadFileVo uploadfileVo);
	
	public List<UploadFileVo> selectByBoardNo(int board_no);
     
	
	
	
	
}
