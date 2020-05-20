package com.ja.freeboard.mapper;

import java.util.List;

import com.ja.freeboard.vo.ReplyVo;

public interface ReplySQLMapper {
    
	public void insert(ReplyVo replyVo);
    
    public List<ReplyVo> SelectByBoardNo(int board_no);
}
